import unittest
import tp_toussaint

class TestToussaint(unittest.TestCase):
    
    def test_nbChiffres(self):
        #Exemple
        self.assertEqual(3,tp_toussaint.nbChiffres(567));
       #TODO self.assertRaises(AssertionError,...,...)
        
  
    
if __name__ == "__main__":
    unittest.main()