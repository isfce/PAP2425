import unittest
import my_vect

class TestMyVect(unittest.TestCase):
    
    def test_estPalindrome(self):
        #Exemple
        self.assertTrue(my_vect.estPalindrome(['a']));
        self.assertTrue(my_vect.estPalindrome([ 'a', 'a' ]));
        self.assertTrue(my_vect.estPalindrome([ 'a', 'b', 'b', 'a' ]));
        self.assertTrue(my_vect.estPalindrome([ 'r', 'a', 'd', 'a', 'r' ]));
        self.assertTrue(my_vect.estPalindrome('RADAR'));
        self.assertFalse(my_vect.estPalindrome([ 'z', 'a', 'd', 'a', 'r' ]));
        self.assertFalse(my_vect.estPalindrome([ 'r', 'a', 'd', 'o', 'r' ]));
        self.assertFalse(my_vect.estPalindrome([ 'r', 'a', 'o', 'r' ]));

if __name__ == "__main__":
    unittest.main()