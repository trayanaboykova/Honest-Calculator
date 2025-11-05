# 🧮 Honest Calculator (Java)

An interactive console-based calculator that evaluates arithmetic expressions and offers **smart, conversational feedback** to the user.  
It detects "lazy" operations, prevents division by zero, stores results in memory, and even asks for confirmation when saving small numbers — just like a “sassy but helpful” assistant.  

Developed as part of my **[JetBrains Academy](https://www.jetbrains.com/academy/)** learning path, this project demonstrates strong understanding of **control flow**, **user input handling**, **conditionals**, and **state management** in Java.

---

## 🚀 Project Overview

The project evolves across multiple stages, each introducing new logic and programming concepts:

- **Input Parsing** – Reads and splits user input into operands and an operator (e.g., `2 + 2`).
- **Validation Logic** – Detects invalid input (non-numeric operands, wrong operators, etc.).
- **Operation Handling** – Supports the four basic arithmetic operations: `+`, `-`, `*`, `/`.
- **Division by Zero Prevention** – Gracefully handles invalid divisions with witty messages.
- **“Lazy” Detection System** – Analyzes inputs and comments on operations like:
  - `1 * 5` → “... very lazy”
  - `0 + 3` → “... very, very lazy”
- **Memory Feature** – Allows storing results in memory (`M`) and reusing them in new calculations.
- **User Confirmation Flow** – Asks for confirmation before overwriting memory with a one-digit number.
- **Conversation-Like Interaction** – Keeps engaging the user with prompts like:
  - `"Do you want to store the result? (y / n)"`
  - `"Do you want to continue calculations? (y / n)"`

---

## 🎯 What I Learned

- 🧠 **Control Flow Mastery:** Designing multi-step logic using nested loops and conditional branches.  
- 💬 **User Interaction:** Implementing multi-level confirmation dialogs with dynamic feedback.  
- 🧮 **Arithmetic Handling:** Managing operations and precision safely without `eval()` or parsing strings as code.  
- 🧩 **State Persistence:** Storing and reusing results across multiple user sessions.  
- 🪶 **Clean Code Practices:** Organizing code into clear, testable, and readable sections.

---

## 🔧 Features

- ✅ Handles addition, subtraction, multiplication, and division.  
- ✅ Prevents invalid input and division by zero.  
- ✅ Detects and comments on “lazy” operations.  
- ✅ Stores results in memory (`M`) and retrieves them in future calculations.  
- ✅ Asks for multi-level confirmation before overwriting one-digit memory values.  
- ✅ Offers continuous calculations in an interactive loop.  

---

## 🛠️ Technologies Used

[![Java](https://skillicons.dev/icons?i=java&theme=light)](https://www.java.com/en/)

---

## 🤔 How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/trayanaboykova/Honest-Calculator.git
2. Open the project in your Java IDE (e.g., IntelliJ IDEA).
3. Compile and run Main.java.
4. Interact with the console — for example:
    ```bash
    Enter an equation
    > 2 + 3
    You are ... lazy
    5.0
    Do you want to store the result? (y / n):

## 📈 Learning Outcomes
By completing this project, I:

Strengthened my understanding of loops, conditionals, and state management in Java.

Learned how to design interactive command-line programs with dynamic feedback.

Improved my ability to translate flowcharts into code systematically.

Developed a deeper appreciation for clean, conversational user experience in console apps.

## 🌟 Acknowledgments

Thanks to JetBrains Academy / Hyperskill for guiding the learning process through structured, progressive projects — helping me grow my Java problem-solving, logic design, and user interaction skills.
