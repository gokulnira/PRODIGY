import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
class Contact implements Serializable 
{
 String name;
 String phoneNumber;
 String emailAddress;
public Contact(String name, String phoneNumber, String emailAddress) {
this.name = name;
this.phoneNumber = phoneNumber;
this.emailAddress = emailAddress;
 }
public String getName() 
{
 return name;
}
 public void setName(String name)
{
 this.name = name;
}
public String getPhoneNumber()
{
 return phoneNumber;
}
public void setPhoneNumber(String phoneNumber)
{
 this.phoneNumber = phoneNumber;
}
public String getEmailAddress()
{
 return emailAddress;
 }
 public void setEmailAddress(String emailAddress)
 {
 this.emailAddress = emailAddress;
 }
public String toString() 
{
return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + emailAddress;
}
}
public class ContactManager
{
private static final String FILE_NAME = "contacts.ser";
private static ArrayList<Contact> contacts = new ArrayList<>();
public static void main(String[] args) 
{
loadContacts();
Scanner scanner = new Scanner(System.in);
while (true) {
            System.out.println("Contact Manager");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    editContact(scanner);
                    break;
                case 4:
                    deleteContact(scanner);
                    break;
                case 5:
                    saveContacts();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
}
}
}
private static void addContact(Scanner scanner)
 {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();

        contacts.add(new Contact(name, phoneNumber, emailAddress));
        System.out.println("Contact added successfully.");
}
private static void viewContacts()
{
if (contacts.isEmpty()) 
{
System.out.println("No contacts available.");
}
else
{
for (int i = 0; i < contacts.size(); i++)
{
System.out.println((i + 1) + ". " + contacts.get(i));
}
}
}
private static void editContact(Scanner scanner)
 {
System.out.print("Enter the number of the contact to edit: ");
int index = scanner.nextInt() - 1;
scanner.nextLine();  
if (index >= 0 && index < contacts.size()) 
{
Contact contact = contacts.get(index);
System.out.print("Enter new name (leave blank to keep current): ");
String name = scanner.nextLine();
if (!name.isEmpty()) 
{
contact.setName(name);
}
System.out.print("Enter new phone number (leave blank to keep current): ");
String phoneNumber = scanner.nextLine();
if (!phoneNumber.isEmpty())
{
contact.setPhoneNumber(phoneNumber);
}
System.out.print("Enter new email address (leave blank to keep current): ");
String emailAddress = scanner.nextLine();
if (!emailAddress.isEmpty()) 
{
contact.setEmailAddress(emailAddress);
}
System.out.println("Contact updated successfully.");
}
else
{
System.out.println("Invalid contact number.");
}
}
private static void deleteContact(Scanner scanner) 
{
System.out.print("Enter the number of the contact to delete: ");
int index = scanner.nextInt() - 1;
scanner.nextLine();
if (index >= 0 && index < contacts.size()) 
{
contacts.remove(index);
System.out.println("Contact deleted successfully.");
}
else
{
System.out.println("Invalid contact number.");
}
}
private static void loadContacts() 
{
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) 
{
contacts = (ArrayList<Contact>) ois.readObject();
} catch (FileNotFoundException e)
{
System.out.println("No previous contacts found. Starting fresh.");
} 
catch (IOException | ClassNotFoundException e)
{
e.printStackTrace();
}
}
private static void saveContacts() 
{
try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
oos.writeObject(contacts);
} 
catch (IOException e) 
{
e.printStackTrace();
}
}
}