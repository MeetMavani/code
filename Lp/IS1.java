// string = "Hello World"

// # Perform AND operation 
// and_result = ""
// for char in string:
//     and_result += chr(ord(char) & 127)

// # Perform XOR operation
// xor_result = ""
// for char in string:
//     xor_result += chr(ord(char) ^ 127)

// print("Original string:", string)
// print("AND result:", and_result)
// print("XOR result:", xor_result)

class IS1 {

    public static void main(String args[]) {

        String str = "Hello World";
        for(int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) & 127);
        }
        System.out.println();
        for(int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) ^ 127);
        }
    }
}