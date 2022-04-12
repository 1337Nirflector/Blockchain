package com.corion;

public class Main {

    /**
     * Test Method
     * This function tests and outputs the blockchain boolean values
     * @param args basic arguments
     */
    public static void main(String[] args) {
        BlockUtils blockUtils = new BlockUtils();
        blockUtils.addBlock("500"); // Block 1: 500
        blockUtils.addBlock("600"); // Block 2: 600
        blockUtils.addBlock("1000"); // Block 3: 1000
        System.out.println(blockUtils.isChainValid()); // Return: true, because no data inside a block has been manipulated
        blockUtils.getBlockChain().get(2).setData("8000"); // Manipulation: value of block 2 has been set to 8000
        System.out.println(blockUtils.isChainValid()); // Return: false, because the data inside of block 2 has been manipulated
    }
}
