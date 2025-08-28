Pokémon Battle Simulator (Java OOP Project)
A console-based game demonstrating fundamental Object-Oriented Programming principles.
⚙️ About the Project
This project is a a simple, console-based simulation of the Pokémon battle system. Developed in Java, the primary objective was to apply and showcase key Object-Oriented Programming (OOP) concepts in a practical and engaging way. The code is structured to clearly demonstrate encapsulation, inheritance, polymorphism, and abstraction, making it an ideal portfolio piece for anyone studying core programming fundamentals.

🔑 Key OOP Concepts Applied
The core of this project lies in its object-oriented design. Each component of the game is represented by a class, and their interactions are managed through well-defined relationships.

1. Encapsulation
The internal state of each Pokemon object, such as its health, attack power, and type, is kept private to the class. Access to and modification of this data is strictly controlled through public methods like getHealth() and takeDamage(int damage), ensuring that the object's data remains valid and protected from unintended external changes. This enforces data integrity and makes the code more robust.

2. Inheritance
A clear class hierarchy is used to model different types of Pokémon. A generic Pokemon class serves as a base class, containing common attributes (name, health) and methods (takeDamage()). Specific types like FirePokemon, WaterPokemon, and GrassPokemon inherit from this base class, allowing them to reuse common code while implementing their own unique behaviors, such as a type-specific attack bonus or weakness.

3. Polymorphism
Polymorphism is extensively used throughout the battle system. A Battle class can initiate a battle between any two objects that are instances of the Pokemon class. Although the attack() method is called universally on both Pokémon, its behavior is determined by the specific subclass it belongs to. For example, FirePokemon.attack() may apply a burn status, while WaterPokemon.attack() may have a chance to lower the opponent's defense, all while being called through a generic Pokemon reference.

4. Abstraction
The Move class serves as an abstract blueprint for all attacks in the game. It defines a common interface with methods like calculateDamage() and getName(). Concrete moves like Tackle, Flamethrower, or WaterGun are concrete classes that implement this abstract class, each providing its own specific logic for how damage is calculated and what effects are applied. This design hides the complex implementation details of each move from the Battle class, which only needs to know that it is dealing with an object of type Move.

✨ Features
Modular Pokémon Classes: Each Pokémon is a distinct object with its own stats and moveset.

Turn-Based Battle System: A simple, turn-based battle loop that simulates a 1-on-1 fight.

Console UI: A clear, text-based interface displays real-time battle logs and the final victor.

🚀 Getting Started
To run this project, ensure you have the Java Development Kit (JDK) installed on your system.

Clone the repository:

git clone https://github.com/l1m120/PokemonGaOleGame

Navigate to the project directory:

cd PokemonGaOleGame

Compile the Java files:

javac src/*.java

Run the main class:

java src.Main

🛠️ Technologies Used
Java: The core programming language.

Object-Oriented Programming (OOP): The fundamental design paradigm.

💡 Future Scope
This project can be expanded in many ways, including:

Implementing a more complex type-effectiveness system (e.g., Water is super effective against Fire).

Adding a full Pokémon team and a trainer class.

Developing a Graphical User Interface (GUI) to replace the console.

Introducing status effects (e.g., burn, poison, paralysis).

Creating a leveling and evolution system.
