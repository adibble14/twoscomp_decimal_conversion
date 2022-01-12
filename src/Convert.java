/**
 * Andrew Dibble
 * Convert.java
 * TCSS 371 - Winter 2022
 * 1/12/2022
 * Assignment 1
 *
 * Write two Java methods to convert a 2’s complement binary number to decimal and vice versa.
 * DO NOT use any shortcuts or predefined methods other than Math class methods.
 * You may NOT use any data structures and must use the basic array manipulation to perform the conversions
 */
public class Convert {

    /**
     * Takes an array of bits to return the corresponding decimal equivalent.
     * @param bits the character array of a binary value
     * @return the corresponding decimal value
     */
    public static int convert2sCompToDecimal(char[] bits){

        boolean negative = false;
        if(bits[0] == '1'){ //checking to see if it is negative and switching it to positive
           negative = true;
            int index = bits.length;
            flip(bits, index);

        }

        int decimal = 0;
        int index = bits.length-2;
        for(int i=1;i<bits.length;i++){
            if(bits[i] == '1'){
                decimal += (int)Math.pow(2,index);
            }
            index--;
        }

        if(negative){
            decimal*=-1;
        }

        return decimal;
    }

    /**
     * Takes a decimal and returns the 2s complement equivalent.
     * Assume that the decimal value won’t require more than 16 bits.
     * @param decimal the input decimal
     * @return a character array with the 2's comp value
     */
    public static char[] convertDecimalTo2sComp(int decimal){

        boolean negative = false;
        if(decimal < 0){  //checking if the number is negative and making it positive
            negative = true;
            decimal = decimal*-1;
        }

        int power = 0;
        int bits = 1;
        while(decimal >= Math.pow(2,power)){  //figures out how many bits we need
            power++;
            bits++;
        }

        char[] array = new char[bits];  //creating a char array to hold the values in
        array[0] = '0';  //setting the first value to 0 because it is positive

        int num = decimal;
        int index = 1;
        for(int i = bits-2; i>=0; i--){      //creating the binary 2's comp value
            if(num >= (int)Math.pow(2,i)){   //if the number is greater than the power of 2, make it a 1
                array[index] = '1';
                num = num - (int)Math.pow(2,i);
            }else{                            //else make it a 0
                array[index] = '0';
            }
            index++;
        }

        if(negative){  //if negative, flip it
            index = bits;
            flip(array, index);
        }

        return array;
    }

    /**
     * This method transforms a positive two's comp number into a negative two's comp number by flipping the digits in the
     * value from the right after the first occurrence of '1'. Ex: 011010 would be 100110
     * @param bits the array
     * @param index the index at which we need to flip the bits
     */
    private static void flip(char[] bits,int index) {
        boolean flip = false;
        while(index>0 && !flip){  //finding where the first 1 is from the right to know when to flip the bits
            if(bits[index-1] == '1'){
                flip = true;
                index = index - 2;
                break;
            }
            index--;
        }

        while(index>=0){   //flipping the digits after the first occurrence of 1 from the right
            if(bits[index] == '1'){
                bits[index] = '0';
            }else{
                bits[index] = '1';
            }
            index--;
        }
    }

}

