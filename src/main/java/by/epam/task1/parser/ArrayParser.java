package by.epam.task1.parser;

import java.util.List;
import java.util.Optional;

public interface ArrayParser {
    List<Integer> parseStringToIntegerList(Optional<String> stringToParse);
}
