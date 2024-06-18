package structure;

import org.horus.task.model.Block;
import org.horus.task.model.CompositeBlock;
import org.horus.task.structure.Wall;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.*;
import static junit.framework.TestCase.assertEquals;
import static org.horus.task.util.DataGenerator.createBlock;
import static org.horus.task.util.DataGenerator.createCompositeBlock;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class WallTest {
    @Test
    public void testFindBlockByColor() {
        //given
        Wall wall = generateData();
        //when
        Optional<Block> foundBlock = wall.findBlockByColor("blue");
        //then
        assertTrue(foundBlock.isPresent());
        assertEquals("blue", foundBlock.get().getColor());
    }

    @Test
    public void testFindBlocksByMaterial() {
        //given
        Wall wall = generateData();
        //when
        List<Block> blocks = wall.findBlocksByMaterial("brick");
        //then
        assertEquals(1, blocks.size());
        assertEquals("brick", blocks.get(0).getMaterial());
    }

    @Test
    public void testCount() {
        //given
        Wall wall = generateData();
        //when
        int count = wall.count();
        //then
        assertEquals(3, count);
    }

    @Test
    public void testEmptyBlocksList() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Wall(null);
        });
        assertEquals("Block list cannot be null", exception.getMessage());
    }

    private Wall generateData() {
        Block block1 = createBlock("red", "wood");
        Block block2 = createBlock("blue", "brick");
        CompositeBlock compositeBlock = createCompositeBlock(asList(block1, block2));
        Wall wall = new Wall(asList(compositeBlock));
        return wall;
    }
}
