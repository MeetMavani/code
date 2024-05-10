from Crypto.Cipher import AES
from Crypto.Random import get_random_bytes
from Crypto.Util.Padding import pad, unpad

def encrypt(message, key):
    cipher = AES.new(key, AES.MODE_CBC)
    padded_message = pad(message.encode(), AES.block_size)
    ciphertext = cipher.encrypt(padded_message)
    return ciphertext

def decrypt(ciphertext, key):
    cipher = AES.new(key, AES.MODE_CBC)
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
