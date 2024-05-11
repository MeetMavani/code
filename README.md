Practical1

def dfs(graph, start):
    visited = set()  # Set to keep track of visited nodes
    stack = [start]  # Stack for DFS traversal
    while stack:
        vertex = stack.pop()  # Pop the top element from the stack
        if vertex not in visited:
            print(vertex, end=' ')  # Process the current node
            visited.add(vertex)
            # Push all adjacent vertices of the popped node to the stack
            for neighbor in graph[vertex]:
                if neighbor not in visited:
                    stack.append(neighbor)

# Example graph represented as an adjacency list
graph = {
    'A': ['B', 'C'],
    'B': ['A', 'D', 'E'],
    'C': ['A', 'F'],
    'D': ['B'],
    'E': ['B', 'F'],
    'F': ['C', 'E']
}

print("DFS traversal starting from node 'A':")
dfs(graph, 'A')```
Practical1


from collections import deque

def bfs(graph, start):
    visited = set()  # Set to keep track of visited nodes
    queue = deque([start])  # Queue for BFS traversal
    while queue:
        vertex = queue.popleft()  # Dequeue the front element from the queue
        if vertex not in visited:
            print(vertex, end=' ')  # Process the current node
            visited.add(vertex)
            # Enqueue all adjacent vertices of the dequeued node
            for neighbor in graph[vertex]:
                if neighbor not in visited:
                    queue.append(neighbor)

# Example graph represented as an adjacency list
graph = {
    'A': ['B', 'C'],
    'B': ['A', 'D', 'E'],
    'C': ['A', 'F'],
    'D': ['B'],
    'E': ['B', 'F'],
    'F': ['C', 'E']
}

print("BFS traversal starting from node 'A':")
bfs(graph, 'A')



Practical2

import heapq

def heuristic(node, goal):
    # Manhattan distance heuristic
    return abs(node[0] - goal[0]) + abs(node[1] - goal[1])

def astar(grid, start, goal):
    open_list = []
    closed_set = set()
    heapq.heappush(open_list, (0, start))  # Push start node with priority 0

    while open_list:
        _, current = heapq.heappop(open_list)  # Pop node with lowest f-value
        if current == goal:
            path = []
            while current != start:
                path.append(current)
                current = grid[current[0]][current[1]][1]  # Follow parent pointers
            path.append(start)
            return path[::-1]  # Reverse path to get from start to goal
        closed_set.add(current)

        for i, j in [(0, -1), (0, 1), (-1, 0), (1, 0)]:  # Neighbors
            neighbor = current[0] + i, current[1] + j
            if 0 <= neighbor[0] < len(grid) and 0 <= neighbor[1] < len(grid[0]):
                if grid[neighbor[0]][neighbor[1]][0] == 0 and neighbor not in closed_set:
                    tentative_g = grid[current[0]][current[1]][0] + 1  # Update g-value
                    if (tentative_g, neighbor) not in open_list:
                        grid[neighbor[0]][neighbor[1]] = tentative_g, current
                        heapq.heappush(open_list, (tentative_g + heuristic(neighbor, goal), neighbor))

# Example grid
grid = [[(0, None) for _ in range(5)] for _ in range(5)]
obstacles = [(1, 1), (1, 2), (2, 2), (3, 2), (3, 3)]
for obstacle in obstacles:
    grid[obstacle[0]][obstacle[1]] = (1, None)  # Mark obstacles

start = (0, 0)
goal = (4, 4)

path = astar(grid, start, goal)
if path:
    print("Path found:", path)
else:
    print("No path found")


    
Practical3

def selection_sort(arr):
n = len(arr)

# Traverse through all array elements
for i in range(n):
# Find the minimum element in the remaining unsorted array
min_index = i
for j in range(i+1, n):
if arr[j] < arr[min_index]:
min_index = j

# Swap the found minimum element with the first element
arr[i], arr[min_index] = arr[min_index], arr[i]

return arr

# Example usage:
arr = [64, 25, 12, 22, 11]
sorted_arr = selection_sort(arr)
print("Sorted array:", sorted_arr)



Practical5

# Function to greet the user
def greet_user():
    print("Hello! I'm Chatty Bot.")
    print("I can guess your age, count numbers, and ask multiple-choice questions.")

# Function to ask the user's name and introduce
def ask_name_and_introduce():
    name = input("Whats your name? ")
    print(f"Nice to meet you, {name}!")

# Function to guess the user's age
def guess_age():
    print('Let me guess your age.')
    print('Enter remainders of dividing your age by 3, 5 and 7.')
    rem3 = int(input())
    rem5 = int(input())
    rem7 = int(input())
    age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105
    print(f"Your age is {age} years old!")


# Function to count numbers from 1 to 10
def count_numbers():
    print("Now I will count to 10:")
    for number in range(1, 11):
        print(number, end=' ')  
    print()  

# Function to ask multiple-choice questions and calculate the score
def ask_questions():
    print("Lets test your knowledge!")
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

# Main program
if __name__ == "__main__":
    greet_user()
    ask_name_and_introduce()
    guess_age()
    count_numbers()
    ask_questions()

    

Practical6

string = "Hello World"

# Perform AND operation 
and_result = ""
for char in string:
    and_result += chr(ord(char) & 127)

# Perform XOR operation
xor_result = ""
for char in string:
    xor_result += chr(ord(char) ^ 127)

print("Original string:", string)
print("AND result:", and_result)
print("XOR result:", xor_result)



Practical7

import java.util.*;

class one {

    public static void main(String[] args) {
        // Define variables
        String plainText, cipherText;
        plainText = "LaboratoryPracticeII"; // Original plaintext
        int k = 0; // Index variable for plaintext characters

        // Initialize encryption and decryption matrices
        char encr[][] = new char[4][5];
        char decr[][] = new char[4][5];

        // Encryption: Fill the encryption matrix with characters from the plaintext
        for(int i = 0; i < encr.length; i++) {
            for(int j = 0; j < encr[0].length; j++) {
                encr[i][j] = plainText.charAt(k++);
            }
        }

        // Form the ciphertext by reading characters column-wise from the encryption matrix
        cipherText = "";
        for(int i = 0; i < encr[0].length; i++) {
            for(int j = 0; j < encr.length; j++) {
                cipherText += encr[j][i];
            }
        }

        // Print the ciphertext
        System.out.println("CipherText: " + cipherText);

        // Decryption: Fill the decryption matrix with characters from the ciphertext
        k = 0; // Reset index variable
        for(int i = 0; i < decr[0].length; i++) {
            for(int j = 0; j < decr.length; j++) {
                decr[j][i] = cipherText.charAt(k++);
            }
        }

        // Print the decrypted text by reading characters row-wise from the decryption matrix
        System.out.print("Decrypted Text: ");
        for(int i = 0; i < decr.length; i++) {
            for(int j = 0; j < decr[0].length; j++) {
                System.out.print(decr[i][j]);
            }
        }
    }
}



Practical8

from Crypto.Cipher import DES
from Crypto.Random import get_random_bytes
from Crypto.Util.Padding import pad, unpad
.a
def encrypt(message, key):
    cipher = DES.new(key, DES.MODE_ECB)
    padded_message = pad(message.encode(), DES.block_size)
    ciphertext = cipher.encrypt(padded_message)
    return ciphertext

def decrypt(ciphertext, key):
    cipher = DES.new(key, DES.MODE_ECB)
    decrypted_message = cipher.decrypt(ciphertext)
    unpadded_message = unpad(decrypted_message, DES.block_size)
    return unpadded_message.decode()

# Example usage
message = "Hello DES!"
key = get_random_bytes(8)  # 8 bytes key for DES
print("Original message:", message)

encrypted_message = encrypt(message, key)
print("Encrypted message:", encrypted_message)

decrypted_message = decrypt(encrypted_message, key)
print("Decrypted message:", decrypted_message)



Practical9

from Crypto.Cipher import AES
from Crypto.Random import get_random_bytes
from Crypto.Util.Padding import pad, unpad

def encrypt(message, key):
    cipher = AES.new(key, AES.MODE_ECB)
    padded_message = pad(message.encode(), AES.block_size)
    ciphertext = cipher.encrypt(padded_message)
    return ciphertext

def decrypt(ciphertext, key):
    cipher = AES.new(key, AES.MODE_ECB)
    decrypted_message = cipher.decrypt(ciphertext)
    unpadded_message = unpad(decrypted_message, AES.block_size)
    return unpadded_message.decode()

# Example usage
message = "Hello World"
key = get_random_bytes(16)  # 16 bytes key for AES
print("Original message:", message)

encrypted_message = encrypt(message, key)
print("Encrypted message:", encrypted_message)

decrypted_message = decrypt(encrypted_message, key)
print("Decrypted message:", decrypted_message)



Practical10

import random
import sympy

def generate_keypair(p, q):
    n = p * q
    phi = (p - 1) * (q - 1)
    e = random.randrange(1, phi)
    gcd_result = sympy.gcd(e, phi)
    while gcd_result != 1:
        e = random.randrange(1, phi)
        gcd_result = sympy.gcd(e, phi)
    d = sympy.mod_inverse(e, phi)
    return ((e, n), (d, n))

def encrypt(public_key, plaintext):
    e, n = public_key
    cipher = [(ord(char) ** e) % n for char in plaintext]
    return cipher

def decrypt(private_key, ciphertext):
    d, n = private_key
    plain = [chr((char ** d) % n) for char in ciphertext]
    return ''.join(plain)

# Example usage
p = 61
q = 53
public_key, private_key = generate_keypair(p, q)
print("Public key:", public_key)
print("Private key:", private_key)

plaintext = "Hello, RSA!"
print("Original text:", plaintext)

encrypted_text = encrypt(public_key, plaintext)
print("Encrypted text:", encrypted_text)

decrypted_text = decrypt(private_key, encrypted_text)
print("Decrypted text:", decrypted_text)


