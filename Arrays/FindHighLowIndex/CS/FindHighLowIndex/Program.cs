using System;
using System.Collections;
using System.Collections.Generic;

namespace FindHighLowIndex
{

    class Person
    {
        public Person(string firstname, string lastname)
        {
            this.FirstName = firstname;
            this.LastName = lastname;
        }

        // using the getter/setter property syntax - this declares a class instance variable called FirstName and creates a getter
        public string FirstName
        {
            get;
        }

        // using the getter/setting property syntax - this declares a class instance variable called LastName and creates a getter and setter 
        public string LastName
        {
            get
            {
                return _LastName;
            }
            set
            {
                if(String.IsNullOrWhiteSpace(value)) // value is a special variable that represents the thing being passed in to the setter
                {
                    throw new ArgumentNullException();
                }
                _LastName = value;
            }
        }

        public string FullName()
        {
            return $"{FirstName} {LastName}";
        }

        private string _LastName;
    }

    class Program
    {
        static void Main(string[] args)
        {
            // strings in C# are immutable just like in java
            string helloWorld = "Hello World!";
            Console.WriteLine($"The String {helloWorld} is {helloWorld.Length} characters long");
            Console.WriteLine(helloWorld);
            string input = "red,blue,yellow,green";
            string[] colors = input.Split(','); // create an array from the colors splitting by ','
            string output = String.Join("|", colors); // recreate a string by joining on '|'
            Console.WriteLine(output);

            // Array
            int[] someIntegers = { 1, 3, 5, 27, 82, 100 }; // no type specified
            int[] someMoreIntegers = new int[3] { 1, 2, 3 }; // type specified
            int[] evenMoreIntegers = new []{ 10,30,33,62,100}; // empty array type specified
            int[,] eggCarton = new int[2, 6]; // egg carton is a 2x6 array

            // List
            List<int> listOfIntegers = new List<int>(new int[]{ 1, 2, 3, 4, 5 }); // declare a list from an array of ints
            List<int> listOfMoreIntegers = new List<int>() { 1, 2, 3, 4, 5 }; // initializer list

            // foreach is a construct in C# that is built-in
            foreach(var item in listOfIntegers)
            {
                Console.WriteLine($"Item {item}");
            }

            // class example
            Person person = new Person("Seymour", "Butts");
            Console.WriteLine(person.FullName());
            Console.WriteLine($"First name = {person.FirstName}, Last name = {person.LastName}");
        }
    }
}
