package preview;

import org.junit.jupiter.api.Test;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_LONG;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ForeignFunctionAndMemoryApiTest {

    @Test
    void foreignFunctionAndMemoryApiTest(){
        assertEquals(13, getStringLengthFromCstrlen("Happy Coding!"));
    }

    long getStringLengthFromCstrlen(String string){
        // 1. Get a lookup object for commonly used libraries
        SymbolLookup stdlib = Linker.nativeLinker().defaultLookup();

        // 2. Get a handle to the "strlen" function in the C standard library
        MethodHandle strlen = Linker.nativeLinker().downcallHandle(
                stdlib.find("strlen").orElseThrow(),
                FunctionDescriptor.of(JAVA_LONG, ADDRESS));

        // 3. Convert Java String to C string and store it in off-heap memory
        long len = 0;
        try (Arena offHeap = Arena.ofConfined()) {
            MemorySegment str = offHeap.allocateUtf8String(string);

            // 4. Invoke the foreign function
             len = (long) strlen.invoke(str);

            System.out.println("len = " + len);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        // 5. Off-heap memory is deallocated at end of try-with-resources
        return len;
    }
}
