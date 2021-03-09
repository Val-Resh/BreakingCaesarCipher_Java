# Breaking the Caesar Cipher.
## A project to practice using Arrays and Statistics.

This project focuses on breaking a single key Caesar Cipher encryption. I've created a Caesar Cipher in a previous project (Link to project: https://github.com/Val-Resh/CaesarCipher_Java). 
You can use that program to encrypt messages and then test this code to break it. Or, find some Caesar Cipher encryptions online and break them with the code in this project.
However, an important remainder is that this code was made with focus on the English language. This means that it will not break Caesar Ciphers were the message encrypted was in another 
language such as German. To do that you would require a different set of stats for that language. 

## Methodology.
The code has two approaches to breaking the Caesar Cipher:

### 1. Assuming the most frequent letter is E.
This was the approach I was taught in an online class. It is based on this graph:

![](https://www3.nd.edu/~busiforc/handouts/cryptography/340px-English-slf.png)

From this graph we make the assumption that the most common letter in the encrypted message will be 'E' and the code is written to find the shift in the alphabet
to then return the encryption key. This encryption key is inserted and the decrypted message is revealed.
This method works well with long encrypted messages because 'E' is indeed a reccuring letter. However, I noticed the problem with this method, which was that
it would not decrypt a message that had no 'E's in its original form such as.

This led me to try a different approach.

### 2. The chi-squared statistical approach.
In this approach the computer attempts every key possible in the Caesar Cipher and checks the results. Now, I could print the results and check by eye which one is the decrypted message.
However, this would be tiresome, so instead I've decided to automate the process by having the computer decide which of the keys has given the decrypted message.
To do this I use the chi-squared formula:

![](https://www.gstatic.com/education/formulas2/355397047/en/chi_squared_test.svg)

By implementing it into the code it allows the computer to pick the correct result and show it to the user, giving us the decrypted message. This approach works even if the decrypted message
had no 'E's in it. Which was the main problem of the 1st approach.

## Last words.
The code contains both approaches. I'd always advice to try the first approach first. If this does not crack the Caesar Cipher encryption. Try the second approach
instead. In most cases the first approach should work and second approach should only be used as a solution if the first one fails. 
