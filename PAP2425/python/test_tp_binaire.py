import unittest
import tp_binaire

class TesttpBinaire(unittest.TestCase):
    
    def test_estMajuscule(self):
        self.assertTrue(tp_binaire.estMajuscule('B'))
        self.assertFalse(tp_binaire.estMajuscule('z'))
        self.assertRaises(AssertionError,tp_binaire.estMajuscule,'+')
    
    def test_nbBytesUtf8(self):
        self.assertEqual(1,tp_binaire.nbBytesUtf8('A'))
        self.assertEqual(2,tp_binaire.nbBytesUtf8('é'))
        self.assertEqual(3,tp_binaire.nbBytesUtf8('€'))
        
        
if __name__ == "__main__":
    unittest.main()