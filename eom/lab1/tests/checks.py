from unittest import TestCase

from utils.checks import check_number


class ChecksTest(TestCase):

    def test_check_number(self):
        binary = '444'
        octal = '89643'
        hexademical = 'Z42G'
        self.assertRaises(ValueError, check_number, binary, 3)
        self.assertRaises(ValueError, check_number, octal, 8)
        self.assertRaises(ValueError, check_number, hexademical, 16)
