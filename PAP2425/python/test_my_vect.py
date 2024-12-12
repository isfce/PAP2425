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

    def test_rechercheBin(self):
        self.assertTrue(my_vect.rechercheBin([5],5))
        self.assertFalse(my_vect.rechercheBin([5],1))
        self.assertFalse(my_vect.rechercheBin([5],10))
        
        self.assertTrue(my_vect.rechercheBin([1, 3, 5, 7, 9],9))
        self.assertTrue(my_vect.rechercheBin([1, 3, 5, 7, 9],1))
        self.assertTrue(my_vect.rechercheBin([1, 3, 5, 7, 9],3))
        self.assertFalse(my_vect.rechercheBin([1, 3, 5, 7, 9],0))
        self.assertFalse(my_vect.rechercheBin([1, 3, 5, 7, 9],10))
        self.assertFalse(my_vect.rechercheBin([1, 3, 5, 7, 9],6))
    
        

if __name__ == "__main__":
    unittest.main()