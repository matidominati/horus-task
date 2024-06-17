package org.horus.task.structure;

import org.horus.task.model.Block;

import java.util.List;
import java.util.Optional;

public interface Structure {
    Optional<Block> findBlockByColor(String color);
    List<Block> findBlocksByMaterial(String material);
    int count();
}
