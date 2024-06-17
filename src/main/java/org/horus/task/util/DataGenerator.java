package org.horus.task.util;

import org.horus.task.model.Block;
import org.horus.task.model.CompositeBlock;

import java.util.List;

public class DataGenerator {
    private static final String COMPOSITE_COLOR = "compositeColor";
    private static final String COMPOSITE_MATERIAL = "compositeMaterial";

    private DataGenerator() {
    }

    public static Block createBlock(String color, String material) {
        return new Block() {
            @Override
            public String getColor() {
                return color;
            }

            @Override
            public String getMaterial() {
                return material;
            }

            @Override
            public String toString() {
                return "Block{color='" + color + "', material='" + material + "'}";
            }
        };
    }

    public static CompositeBlock createCompositeBlock(List<Block> blocks) {
        return new CompositeBlock() {
            @Override
            public List<Block> getBlocks() {
                return blocks;
            }

            @Override
            public String getColor() {
                return COMPOSITE_COLOR;
            }

            @Override
            public String getMaterial() {
                return COMPOSITE_MATERIAL;
            }

            @Override
            public String toString() {
                return "CompositeBlock{blocks=" + blocks + "}";
            }
        };
    }
}

