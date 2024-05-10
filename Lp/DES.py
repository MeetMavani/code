from Crypto.Cipher import DES
from Crypto.Random import get_random_bytes
from Crypto.Util.Padding import pad, unpad

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
message = "Hello World"
key = get_random_bytes(8)  # 8 bytes key for DES
print("Original message:", message)

encrypted_message = encrypt(message, key)
print("Encrypted message:", encrypted_message)

decrypted_message = decrypt(encrypted_message, key)
print("Decrypted message:", decrypted_message)
