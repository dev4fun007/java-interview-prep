###Streams
- Stream inherits from **BaseStream** class
- Streams do lazy evaluation - compute only when terminal operation is performed
- Specialized streams, IntStream and others, to prevent boxing and unboxing a number of times during stream operations
----
###Date-Time API
- Thread safe, immutable
- Many new operations on Date and Time
- Supports LocalDate/Time or ZonedDateTime
---

###SplitIterator
- An iterator with support for parallel iteration
- Use splitIterator.trySplit() (returns null if split not possible) method to split the collection based on Sorting, randomness etc 
- Can be used for sequential iteration as well