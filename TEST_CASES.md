# Sample Test Cases and Expected Outputs

This document provides sample test cases you can use to verify the program works correctly.

---

## Test Case 1: Normal Operation (Full 10 Grades)

### Input:
```
85
90
78
92
88
95
82
89
91
87
```

### Expected Output:
- All 10 grades should be displayed
- Average should be: 87.70
- Letter Grade: B

---

## Test Case 2: Early Exit with 999

### Input:
```
95
88
92
999
```

### Expected Output:
- Should display 3 grades
- Average should be: 91.67
- Letter Grade: A
- Message: "Grade entry stopped by user."

---

## Test Case 3: Grade A Performance

### Input:
```
95
96
92
98
94
999
```

### Expected Output:
- Average should be: 95.00
- Letter Grade: A
- Feedback: "Excellent work! Keep up the outstanding performance!"

---

## Test Case 4: Grade B Performance

### Input:
```
85
88
82
86
999
```

### Expected Output:
- Average should be: 85.25
- Letter Grade: B
- Feedback: "Great job! You're doing well!"

---

## Test Case 5: Grade C Performance

### Input:
```
75
72
78
71
999
```

### Expected Output:
- Average should be: 74.00
- Letter Grade: C
- Feedback: "Good effort! Keep working to improve!"

---

## Test Case 6: Grade D Performance

### Input:
```
65
62
68
63
999
```

### Expected Output:
- Average should be: 64.50
- Letter Grade: D
- Feedback: "You're passing, but consider seeking additional help."

---

## Test Case 7: Grade F Performance

### Input:
```
55
50
45
58
999
```

### Expected Output:
- Average should be: 52.00
- Letter Grade: F
- Feedback: "Please seek assistance to improve your performance."

---

## Test Case 8: Invalid Input Handling

### Input:
```
105 (should show error)
95 (valid)
-10 (should show error)
88 (valid)
abc (should show error)
92 (valid)
999
```

### Expected Output:
- Should show error for 105: "Grade must be between 0 and 100"
- Should show error for -10: "Grade must be between 0 and 100"
- Should show error for "abc": "Please enter a valid number"
- Should only record three valid grades: 95, 88, 92
- Average should be: 91.67
- Letter Grade: A

---

## Test Case 9: Boundary Testing

### Input:
```
100 (max valid)
0 (min valid)
90 (A threshold)
80 (B threshold)
70 (C threshold)
60 (D threshold)
999
```

### Expected Output:
- All grades should be accepted
- Average should be: 66.67
- Letter Grade: D

---

## Test Case 10: Immediate Exit

### Input:
```
999
```

### Expected Output:
- Message: "No grades were entered. Program terminating."
- Program should exit gracefully

---

## Verification Checklist

After running test cases, verify:

- [ ] Program compiles without errors
- [ ] All 10 grades can be entered
- [ ] 999 stops grade entry early
- [ ] Invalid grades (< 0 or > 100) are rejected with clear error messages
- [ ] Non-numeric input is handled gracefully
- [ ] All entered grades are displayed correctly
- [ ] Average is calculated correctly
- [ ] Letter grade matches the grading scale
- [ ] Appropriate feedback message is displayed
- [ ] Program exits cleanly
- [ ] No runtime errors or exceptions occur

---

## How to Test

1. Compile the program:
   ```bash
   javac QuizGradeCalculator.java
   ```

2. Run the program:
   ```bash
   java QuizGradeCalculator
   ```

3. Enter the test inputs from any test case above

4. Compare actual output with expected output

5. Document any discrepancies (there should be none!)

---

## Expected Program Behavior Summary

✅ **Compilation**: No errors  
✅ **Input Validation**: Rejects invalid grades  
✅ **Loop Control**: Exits on 999 or after 10 grades  
✅ **Array Storage**: Correctly stores all valid grades  
✅ **Display**: Shows all grades in formatted output  
✅ **Calculation**: Computes accurate average  
✅ **Decision Logic**: Assigns correct letter grade  
✅ **Error Handling**: Gracefully handles all errors  
✅ **User Experience**: Clear messages and formatting  

---

**Note**: Feel free to test with your own custom values to further verify the program's correctness!
