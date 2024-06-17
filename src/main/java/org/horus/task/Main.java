package org.horus.task;

import org.horus.task.model.Block;
import org.horus.task.model.CompositeBlock;
import org.horus.task.structure.Wall;

import java.util.List;

import static org.horus.task.util.DataGenerator.createBlock;
import static org.horus.task.util.DataGenerator.createCompositeBlock;

public class Main {
    public static void main(String[] args) {
        final String COLOR = "Black";
        final String MATERIAL = "Brick";

        Block block1 = createBlock("Black", "Wood");
        Block block2 = createBlock("Black", "Concrete");
        Block block3 = createBlock("White", "Wood");
        Block block4 = createBlock("White", "Brick");
        Block block5 = createBlock("Grey", "Concrete");
        Block block6 = createBlock("Grey", "Wood");
        Block block7 = createBlock("Red", "Brick");
        Block block8 = createBlock("Red", "Wood");

        CompositeBlock compositeBlock = createCompositeBlock(List.of(block1, block2, block3, block4, block5));

        Wall wall = new Wall(List.of(compositeBlock, block6, block7, block8));

        //findBlocksByColor
        wall.findBlocksByColor(COLOR).ifPresentOrElse(
                block -> System.out.println("Found block: " + block),
                () -> System.out.println("No " + COLOR + " block found")
        );

        //findBlocksByMaterial
        List<Block> blocks = wall.findBlocksByMaterial(MATERIAL);
        if (!blocks.isEmpty()) {
            System.out.println("Found blocks: " + blocks);
        } else {
            System.out.println("No blocks found with material " + MATERIAL);
        }

        //count
        int blockCount = wall.count();
        System.out.println("Total number of blocks: " + blockCount);
    }
}
