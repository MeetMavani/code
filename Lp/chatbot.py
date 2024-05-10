import random

# Function to greet the user
def greet_user():
    print("Hello! I’m Chatty Bot.")
    print("I can guess your age, count numbers, and ask multiple-choice questions.")

# Function to ask the user's name and introduce
def ask_name_and_introduce():
    name = input("What’s your name? ")
    print(f"Nice to meet you, {name}!")

# Function to guess the user's age
def guess_age():
    print("Let me guess your age.")
    remainder = int(input("Enter the remainder when you divide your age by 3: "))
    age = (remainder + 2) * 3
    print(f"Your age is {age} years old!")

# Function to count numbers from 1 to 10
def count_numbers():
    print("Now I will count to 10:")
    for number in range(1, 11):
        print(number, end=' ')  
    print()  

# Function to ask multiple-choice questions and calculate the score
def ask_questions():
    print("Let’s test your knowledge!")
    questions = {
        "What is the capital of France?": "Paris",
        "Which planet is known as the Red Planet?": "Mars",
        "Who wrote 'Romeo and Juliet'?": "William Shakespeare"
    }

    correct_answers = 0
    for question, correct_answer in questions.items():
        print(question)
        user_answer = input("Enter your answer: ").strip().capitalize()
        if user_answer == correct_answer:
            print("Correct!")
            correct_answers += 1
        else:
            print("Incorrect!")
    
    print(f"You got {correct_answers} out of {len(questions)} questions correct.")

# Main function to orchestrate the conversation
def main():
    greet_user()
    ask_name_and_introduce()
    guess_age()
    count_numbers()
    ask_questions()

# Check if the script is executed as the main program
if __name__ == "__main__":
    main()
