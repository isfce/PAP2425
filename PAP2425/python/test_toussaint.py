import unittest
import tp_toussaint

class TestToussaint(unittest.TestCase):
    
    def test_nbChiffres(self):
        #Exemple
        self.assertEqual(1,tp_toussaint.nbChiffres(0))
        self.assertEqual(1,tp_toussaint.nbChiffres(9))
        self.assertEqual(2,tp_toussaint.nbChiffres(10))
        self.assertEqual(3,tp_toussaint.nbChiffres(567))
        self.assertRaises(AssertionError,tp_toussaint.nbChiffres,-1)
     
    def test_inverseNb(self):
        self.assertEqual(2,tp_toussaint.inverseNbr(20))
        self.assertEqual(765,tp_toussaint.inverseNbr(567))
        self.assertEqual(12,tp_toussaint.inverseNbr(21))
        self.assertEqual(9,tp_toussaint.inverseNbr(9))
        self.assertEqual(0,tp_toussaint.inverseNbr(0))
        self.assertRaises(AssertionError,tp_toussaint.inverseNbr,-1)

    def test_convertTemp(self):
        self.assertEqual(38.0,tp_toussaint.convertTemp(38.0, 'C', 'C'))
        self.assertEqual(100.4,tp_toussaint.convertTemp(38.0, 'C', 'F'))
        self.assertEqual(311.15,tp_toussaint.convertTemp(38.0, 'C', 'K'))
        self.assertEqual(38.0,tp_toussaint.convertTemp(100.4, 'F', 'C'))
        self.assertEqual(311.15,tp_toussaint.convertTemp(100.4, 'F', 'K'))
        self.assertRaises(AssertionError,tp_toussaint.convertTemp,-1,'K','C')
        self.assertRaises(AssertionError,tp_toussaint.convertTemp,10,'X','C')
        self.assertRaises(AssertionError,tp_toussaint.convertTemp,10,'K','X')
        
  
    
if __name__ == "__main__":
    unittest.main()