# Dynamic Programming (DP)

Dynamic programming (DP) is a method for solving problems by breaking them down into smaller overlapping subproblems and storing the solutions to avoid redundant calculations.

## MY METHOD:

1. try to represent the problem to index based problem
2. do all the stuff on that index
3. take the result(min/max/calculated)

## Key Concepts

1. **Divide the Problem into Subproblems**:

   - Complex problems are split into smaller, manageable subproblems that are easier to solve.

2. **Store Subproblem Solutions**:

   - Once a subproblem is solved, its result is stored (typically in a table or array) so it doesn't need to be solved again.

3. **Build the Solution Step by Step**:

   - Starting from the simplest subproblems, use their solutions to progressively solve larger parts of the problem.

## Example: Fibonacci Sequence

Let’s solve the Fibonacci sequence using dynamic programming. In the Fibonacci sequence:

Using DP, we store each Fibonacci number after computing it, so we don’t compute the same value multiple times.

### DP Approach (Code Example):

```javascript
function fibonacci(n) {
  let dp = [0, 1]; // base cases

  for (let i = 2; i <= n; i++) {
    dp[i] = dp[i - 1] + dp[i - 2]; // build up the solution
  }

  return dp[n]; // return the nth Fibonacci number
}
```

In this approach:

- We **store** the Fibonacci numbers in an array (`dp`) as we compute them.
- Each Fibonacci number is calculated **once** , avoiding redundant work.

### Why Dynamic Programming?

- **Avoid Redundant Work** : Each subproblem is solved only once and stored for future use.
- **Optimal Substructure** : The solution to a complex problem is built using the solutions to its subproblems.

## When to Use Dynamic Programming?

- **Overlapping Subproblems** : If the same subproblem is solved multiple times, like in the Fibonacci sequence.
- **Optimal Substructure** : The problem’s solution can be composed of solutions to its subproblems.

## Common Dynamic Programming Problems:

- Fibonacci numbers
- Knapsack problem
- Longest Common Subsequence

By breaking problems into smaller, reusable parts, dynamic programming improves efficiency and avoids redundant work.

## Solution/Optimization methods

### 1. Recurssion

- recursively call same function.

```javascript
function fib(n) {
  // Base case: if n is 0 or 1, return n
  if (n <= 1) {
    return n;
  }
  return fib(n - 1) + fib(n - 2);
}
```

NOTE: it recursively calculate redundant calculation(same input) to avoid that we use memoization.

### **2. Memoization (Top-Down Approach)**

- Concept: Solve the problem recursively and store intermediate results in a cache (usually a hash map or an array) to avoid redundant computations.
- How it works:
  - Start solving the problem from the top (main problem) and break it down into subproblems recursively .
  - Store the result of each subproblem in a memoization table (array or hashmap).
  - If a subproblem has already been solved, return the cached result instead of recomputing.

```javascript
function fib(n, memo = {}) {
  if (n <= 1) return n;
  if (n in memo) return memo[n]; // Return cached result
  memo[n] = fib(n - 1, memo) + fib(n - 2, memo); // Store result
  return memo[n];
}
```

NOTE:

- Uses recursion, which may lead to **stack overflow** for large inputs.
- Requires extra space for recursion call stack ( **O(N) space complexity** ).
- To avoid the recursion we use tabulation

### 3. **Tabulation (Bottom-Up Approach)**

- **Concept:** Solve the problem **iteratively** by filling a table (array) **from the smallest subproblems to the main problem** .
- **How it works:**
  - Start by solving the **smallest subproblem** .
  - Use its result to build up solutions to **larger subproblems** .
  - Store results in a **table (array)** instead of using recursion.

```javascript
function fib(n) {
  if (n <= 1) return n;
  let dp = new Array(n + 1);
  dp[0] = 0;
  dp[1] = 1;
  for (let i = 2; i <= n; i++) {
    dp[i] = dp[i - 1] + dp[i - 2]; // Build the solution iteratively
  }
  return dp[n];
}
```

NOTE:

- Avoids recursion overhead (no stack overflow), But might use **extra space** (O(N)) if storing all subproblem results.
- To avoid extra space we go for space optimized tabulation approach

### **4. Space Optimization in Tabulation**

- Instead of storing all Fibonacci numbers, we only keep track of the last two numbers:

```javascript
function fib(n) {
  if (n <= 1) return n;
  let a = 0,
    b = 1;
  for (let i = 2; i <= n; i++) {
    let temp = a + b;
    a = b;
    b = temp;
  }
  return b;
}
```

### **Comparison Table**

| Feature           | Memoization (Top-Down)                     | Tabulation (Bottom-Up)                                |
| ----------------- | ------------------------------------------ | ----------------------------------------------------- |
| Approach          | Recursive                                  | Iterative                                             |
| Computation Order | On demand (calls made only when needed)    | Solves all subproblems, even if some aren't needed    |
| Space Complexity  | O(N) (due to recursion stack + memo table) | O(N), can be optimized to O(1)                        |
| Time Complexity   | O(N) (avoids recomputation)                | O(N) (iterative)                                      |
| Best Use Case     | When not all subproblems need to be solved | When all subproblems contribute to the final solution |
