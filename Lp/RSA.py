import random

def mod_inverse(a, m):
    """Calculate the modular multiplicative inverse of a mod m."""
    m0, x, y = m, 0, 1
    while a > 1:
        q, m, a = a // m, a % m, m
        x, y = y - q * x, x
    return y + m0 if y < 0 else y

def generate_keypair(p, q, e):
    """Generate RSA public and private keys."""
    n = p * q
    phi = (p - 1) * (q - 1)
    d = mod_inverse(e, phi)
    return ((e, n), (d, n))

def encrypt(pk, plaintext):
    """Encrypt the plaintext using the public key."""
    key, n = pk
    return [pow(ord(char), key, n) for char in plaintext]

def decrypt(pk, ciphertext):
    """Decrypt the ciphertext using the private key."""
    key, n = pk
    return ''.join(chr(pow(char, key, n)) for char in ciphertext)

# Example usage:
if __name__ == "__main__":
    # Choose two prime numbers and value of e
    p, q, e = 61, 53, 17
    public_key, private_key = generate_keypair(p, q, e)
    print("Public key:", public_key)
    print("Private key:", private_key)

    # Encrypt the message
    plaintext = "Hello, world!"
    encrypted_msg = encrypt(public_key, plaintext)
    print("Encrypted message:", ''.join(map(str, encrypted_msg)))

    # Decrypt the message
    decrypted_msg = decrypt(private_key, encrypted_msg)
    print("Decrypted message:", decrypted_msg)