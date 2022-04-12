package com.corion;

import java.util.ArrayList;
import java.util.List;

public class BlockUtils {

    private List<Block> blockChain = new ArrayList<>();

    public List<Block> getBlockChain() {
        return blockChain;
    }

    private void createGenesisBlock() {
        blockChain.add(new Block(0, "0", "Hello"));
    }

    private Block getPreviousBlock() {
        if (blockChain.isEmpty()) {
            createGenesisBlock();
        }
        return blockChain.get(blockChain.size() - 1);
    }

    public void addBlock(String data) {
        Block previous = getPreviousBlock();
        Block newBlock = new Block(previous.getIndex() + 1, data, previous.getHash());
        blockChain.add(newBlock);
    }

    public boolean isChainValid() {
        for (int iterator = 1; iterator < blockChain.size(); iterator++) {
            Block currentBlock = blockChain.get(iterator);
            Block previousBlock = blockChain.get(iterator - 1);

            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }
}
