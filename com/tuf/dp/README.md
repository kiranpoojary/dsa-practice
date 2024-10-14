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

* We **store** the Fibonacci numbers in an array (`dp`) as we compute them.
* Each Fibonacci number is calculated  **once** , avoiding redundant work.

### Why Dynamic Programming?

* **Avoid Redundant Work** : Each subproblem is solved only once and stored for future use.
* **Optimal Substructure** : The solution to a complex problem is built using the solutions to its subproblems.

## When to Use Dynamic Programming?

* **Overlapping Subproblems** : If the same subproblem is solved multiple times, like in the Fibonacci sequence.
* **Optimal Substructure** : The problem’s solution can be composed of solutions to its subproblems.

## Common Dynamic Programming Problems:

* Fibonacci numbers
* Knapsack problem
* Longest Common Subsequence

By breaking problems into smaller, reusable parts, dynamic programming improves efficiency and avoids redundant work.
