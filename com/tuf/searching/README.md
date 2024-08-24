# Binary Search

1. Normal Binary Serach
2. Recursive Binary Search

## Overflow Case

Imagine you have a big array with size int_max, when the search element in last position u will find

mid=(low+high)/2 where mid variable is int ans its not support the mid value

so Use: 

1. long OR
2. mid=low+((high-low)/2)
