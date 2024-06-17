package org.horus.task.model;

import java.util.List;

public interface CompositeBlock extends Block {
    List<Block> getBlocks();
}