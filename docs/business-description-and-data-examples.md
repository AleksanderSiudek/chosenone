# Business Description and Data Examples

## Purpose
This application is used to prepare settlements for one selected counterparty within a defined accounting period.

The business question is:
- does the counterparty still owe money to us, or
- do we owe money back to the counterparty.

## Business Context
The settlement is based on one payment type only (for example: Operating Advance).

During the accounting period:
- the counterparty may receive multiple charges,
- the counterparty may make multiple payments,
- an opening balance exists at the beginning of the period.

Opening balance meaning:
- positive opening balance means counterparty already owes money to us,
- negative opening balance means we already owe money to the counterparty.

## Required Business Outcome
For a selected counterparty and one payment type, the system must return:
- final settlement amount,
- clear business status:
  - counterparty owes us,
  - we owe counterparty,
  - fully settled.

## Data Example 1: Counterparty Owes Us
Business case: opening underpayment and lower total payments than total obligations.

Input data:
- counterpartyId: C-1001
- paymentType: OPERATING_ADVANCE
- periodFrom: 2026-01-01
- periodTo: 2026-03-31
- openingBalance: 100.00
- charges: 300.00, 300.00, 300.00
- payments: 250.00, 300.00, 280.00

Expected business result:
- final amount: 170.00
- status: COUNTERPARTY_OWES_US

## Data Example 2: We Owe Counterparty
Business case: opening overpayment and payments exceed obligations.

Input data:
- counterpartyId: C-1002
- paymentType: OPERATING_ADVANCE
- periodFrom: 2026-01-01
- periodTo: 2026-03-31
- openingBalance: -50.00
- charges: 200.00, 200.00, 200.00
- payments: 250.00, 250.00, 250.00

Expected business result:
- final amount: -200.00
- status: WE_OWE_COUNTERPARTY

## Data Example 3: Fully Settled
Business case: all obligations are exactly balanced.

Input data:
- counterpartyId: C-1003
- paymentType: OPERATING_ADVANCE
- periodFrom: 2026-01-01
- periodTo: 2026-03-31
- openingBalance: 0.00
- charges: 150.00, 150.00, 150.00
- payments: 150.00, 150.00, 150.00

Expected business result:
- final amount: 0.00
- status: SETTLED
