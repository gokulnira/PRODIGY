import java.util.Scanner;
public class TemperatureConvert 
{
 public static double celsiusToFahrenheit(double celsius) 
{
 return (celsius * 9/5) + 32;
}
 public static double celsiusToKelvin(double celsius)
 {
   return celsius + 273.15;
 }
public static double fahrenheitToCelsius(double fahrenheit) 
{
 return (fahrenheit - 32) * 5/9;
}
public static double fahrenheitToKelvin(double fahrenheit)
{
 return (fahrenheit - 32) * 5/9 + 273.15;
}
public static double kelvinToCelsius(double kelvin)
{
return kelvin - 273.15;
}
 public static double kelvinToFahrenheit(double kelvin)
{
 return (kelvin - 273.15) * 9/5 + 32;
}
public static void main(String[] args)
 {
Scanner scanner = new Scanner(System.in);
System.out.println("Temperature Conversion Program");
System.out.print("Enter the temperature value: ");
double value = scanner.nextDouble();
System.out.print("Enter the unit of measurement (C for Celsius, F for Fahrenheit, K for Kelvin): ");
String unit = scanner.next().toUpperCase();
        switch (unit) 
{
            case "C":
                double fahrenheit = celsiusToFahrenheit(value);
                double kelvin = celsiusToKelvin(value);
                System.out.printf("%.2f°C is equivalent to %.2f°F and %.2fK%n", value, fahrenheit, kelvin);
                break;
            case "F":
                double celsiusFromF = fahrenheitToCelsius(value);
                double kelvinFromF = fahrenheitToKelvin(value);
                System.out.printf("%.2f°F is equivalent to %.2f°C and %.2fK%n", value, celsiusFromF, kelvinFromF);
                break;
            case "K":
                double celsiusFromK = kelvinToCelsius(value);
                double fahrenheitFromK = kelvinToFahrenheit(value);
                System.out.printf("%.2fK is equivalent to %.2f°C and %.2f°F%n", value, celsiusFromK, fahrenheitFromK);
                break;
            default:
                System.out.println("Invalid unit of measurement entered. Please enter C, F, or K.");
                break;
 }
        
  scanner.close();
}
}