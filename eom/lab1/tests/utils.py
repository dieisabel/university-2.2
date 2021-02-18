from unittest import TestCase

from utils import convert_to_decimal
from utils import convert_to_base


class ConvertTest(TestCase):

    def test_convert_to_decimal(self):
        binary = convert_to_decimal(1011110101, 2)
        octal = convert_to_decimal(1342563, 8)
        hexademical = convert_to_decimal('3F2C', 16)
        self.assertEqual(binary, 757)
        self.assertEqual(octal, 378227)
        self.assertEqual(hexademical, 16172)

    def test_convert_to_base(self):
        binary = convert_to_base(6532, 2)
        octal = convert_to_base(1890, 8)
        hexademical = convert_to_base(109753, 16)
        self.assertEqual(binary, '1100110000100')
        self.assertEqual(octal, '3542')
        self.assertEqual(hexademical, '1ACB9')
