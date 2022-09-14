package ufc.l33.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import static java.util.function.Predicate.not;

public class Main {
	public static void main(String[] args) throws IOException {
	// Problem 1
	Path result = Paths.get("src\\triangles_in.dat");
	var trList = Files.readString(result).lines()
            .filter(not(String::isBlank)).map(String::strip)
            .map(Triangle::makeTriangle).map(Optional::orElseThrow)
            .filter(not(Triangle::isRightTriangle))
            .collect(Collectors.toUnmodifiableList());
    		System.out.println(trList);
    		
    // Problem 2
    		var trList2 = Files.readString(result)
    	            .lines().filter(not(String::isBlank)).map(String::strip)
    	            .map(Triangle::makeTriangle).map(Optional::orElseThrow)
    	            .filter(not(Triangle::isRightTriangle)).collect(Collectors.toUnmodifiableList());
    	    		System.out.println(trList2);
    		
    // Problem 3
            var trList3 = Files.readString(result)
                    .lines()
                    .filter(not(String::isBlank)).map(String::strip).map(Triangle::makeTriangle)
                    .map(Optional::orElseThrow).filter(Triangle::isRightTriangle)
                    .findFirst().orElseThrow();
            System.out.println(trList3);
   // Problem 4
             var trArray = Files
                    .readString(result).lines()
                    .filter(not(String::isBlank)).map(String::strip)
                    .map(Triangle::makeTriangle).map(Optional::orElseThrow)
                    .filter(not(Triangle::isRightTriangle)).collect(Collectors.toUnmodifiableList())
                    .toArray(Triangle[]::new);
            System.out.println(Arrays.toString(trArray));
   // Problem 5
            Path newOutPath = Path.of("src\\triangles_out.dat");
            var triangles = Files.readString(result)
                    .lines().filter(not(String::isBlank))
                    .map(String::strip).map(Triangle::makeTriangle)
                    .map(Optional::orElseThrow).filter(not(Triangle::isRightTriangle))
                    .collect(Collectors.toUnmodifiableList()).toArray(Triangle[]::new);
            Files.writeString(newOutPath, Arrays.toString(triangles));
	}
}
