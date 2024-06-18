package org.horus.task.structure;

import org.horus.task.model.Block;
import org.horus.task.model.CompositeBlock;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        if (blocks == null) {
            throw new IllegalArgumentException("Block list cannot be null");
        }
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return getAllBlocks(blocks)
                .filter(block -> block.getMaterial().equals(color))
                        .findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return getAllBlocks(blocks)
                .filter(block -> block.getMaterial().equals(material))
                .collect(toList());
    }

    @Override
    public int count() {
        return (int) getAllBlocks(blocks).count();
    }

    private Stream<Block> getAllBlocks(List<Block> blocks) {
        return blocks.stream()
                .flatMap(block -> block instanceof CompositeBlock
                        ? concat(Stream.of(block), getAllBlocks(((CompositeBlock) block).getBlocks()))
                        : Stream.of(block));
    }
}

