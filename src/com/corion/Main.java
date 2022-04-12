package com.corion;

public class Main {

    public static void main(String[] args) {
        BlockUtils blockUtils = new BlockUtils();
        blockUtils.addBlock("500");
        blockUtils.addBlock("600");
        blockUtils.addBlock("1000");
        System.out.println(blockUtils.isChainValid());
        blockUtils.getBlockChain().get(2).setData("8000");
        System.out.println(blockUtils.isChainValid());
    }
}
