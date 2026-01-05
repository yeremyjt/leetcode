# DoorDash API/Code Craft Interview Preparation Guide

## 1. The Format: What to Expect
- **The Prompt**: You will likely be given a business scenario (e.g., "Calculate driver pay," "Validate a menu update," "Apply a discount code").
- **The Environment**: Usually CoderPad or a similar online IDE. You can run your code.
- **The Goal**: Write a class or function that takes an input (often JSON or a complex object) and returns the correct output, handling edge cases and errors.
- **The Twist**: It often starts simple (Part 1) and gets more complex (Part 2 & 3) with new requirements that force you to refactor your code.

## 2. Top 3 Likely Scenarios (DoorDash Domains)
DoorDash questions almost always map to their actual business. Prepare for these specific domains:

### Scenario A: Driver Pay / Delivery Fees
- **Prompt**: "Calculate the total pay for a Dasher based on base pay, time spent, and mileage. Now add 'peak pay' based on time of day."
- **Key Skills**: Date/Time manipulation (handling timezones is huge!), floating point math (money), modular logic.

### Scenario B: Menu & Inventory Management
- **Prompt**: "Design an API to update a menu. A menu has categories, items, and modifiers (e.g., 'Extra Cheese'). Ensure modifiers are valid for the item."
- **Key Skills**: Tree/Graph data structures (Menu -> Category -> Item), input validation, error throwing.

### Scenario C: Scheduling & Availability
- **Prompt**: "A Dasher wants to schedule a shift. Check if the slot is valid given a list of existing shifts and store hours."
- **Key Skills**: Interval overlapping logic (checking if [Start, End] overlaps with another time range).

## 3. The "Hidden" Grading Rubric (How to Pass)
Since there is no "dynamic programming trick" to find, they grade you on Engineering Quality.

- **Input Validation**: Never trust the input. If the function expects a positive price and gets -10, throw a specific error (e.g., `InvalidPriceException`).
- **Clean Abstractions**: Don't write one giant if/else block. Break logic into helper functions like `isStoreOpen()`, `calculateBaseFee()`, `applyPeakMultiplier()`.
- **Extensibility**: When they ask for "Part 2", your code shouldn't break. Use classes/interfaces where appropriate so you can swap rules easily.
- **Testing**: This is critical. Do not wait for them to ask. Write manual test cases at the bottom of your file to prove your code works for:
    - Happy path (Standard order)
    - Edge case (Zero quantity, negative price)
    - Null/Empty case (Missing fields)

## 4. Mock Practice Problem
Try to solve this problem in 45 minutes to simulate the interview.

### Prompt:
"We need an API to calculate the delivery fee for an order."

**Part 1:**
- Base fee is $2.00.
- Add $0.50 per mile for the first 5 miles.
- Add $1.00 per mile for any distance beyond 5 miles.

**Part 2 (The Twist):**
- If the order time is during 'Rush Hour' (5:00 PM - 8:00 PM), multiply the total fee by 1.2x.
- If the customer is a 'DashPass' member, they get free delivery (fee = $0) only if the order total is above $25.00."

### How a Senior Engineer solves this:
1. **Clarify Input**: "Does distance come in as an integer or float? What format is the timestamp string?"
2. **Define Models**: Create a simple class `Order` to hold the input data rather than passing raw variables.
3. **Modularize**:

```python
# Python Example (Applies to Java/JS as well)
from datetime import datetime

class DeliveryCalculator:
    BASE_FEE = 2.00

    def calculate_fee(self, order, customer_profile):
        # 1. Validation
        if order.distance < 0:
            raise ValueError("Distance cannot be negative")

        # 2. Logic Segregation
        fee = self._calculate_distance_fee(order.distance)
        fee = self._apply_rush_hour_multiplier(fee, order.timestamp)

        # 3. Final Overrides (DashPass)
        if self._is_eligible_for_dashpass(order, customer_profile):
            return 0.00

        return round(fee, 2)

    def _calculate_distance_fee(self, distance):
        if distance <= 5:
            return self.BASE_FEE + (distance * 0.50)
        else:
            # First 5 miles at 0.50, rest at 1.00
            return self.BASE_FEE + (5 * 0.50) + ((distance - 5) * 1.00)
```

## 5. Final Tips
- **Don't set up a server unless asked**: Usually, you don't need to write `app.get('/route')` boilerplate unless they explicitly ask. Focus on the controller/service logic.
- **Time handling is a trap**: Be comfortable parsing ISO strings (e.g., "2023-10-27T17:30:00Z") into your language's Date object.
- **Talk while you code**: Explain why you are creating a separate function. "I'm separating the rush hour logic here so we can easily change the hours later if the business needs it."