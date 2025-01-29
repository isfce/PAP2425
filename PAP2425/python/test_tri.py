import tri
import unittest
class TestTri(unittest.TestCase):
    
    def test_Bulle(self):
        l1=[4]
        tri.triBulle(l1)
        self.assertListEqual([4],l1)
        
        l1=[1,2]
        tri.triBulle(l1)
        self.assertListEqual([1,2],l1)
        
        l1=[4,2]
        tri.triBulle(l1)
        self.assertListEqual([2,4],l1)
        
        l1=[4,3,2,1]
        tri.triBulle(l1)
        self.assertListEqual([1,2,3,4],l1)



if __name__ == "__main__":
    unittest.main()