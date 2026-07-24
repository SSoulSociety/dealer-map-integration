# Day 7 — React Hook Form & Transactions Validation

## What I did today
Today I built the capability search form on the Transactions (turkcell.com.tr) page. I integrated `react-hook-form` to manage form states and `yup` for validations. I added filters for operation types (new line, repair, numara taşıma), working hour types (weekend, late close), and store types (TIM, Franchise), forcing the user to select an operation type before searching.

## What I learned
- **React Hook Form:** Learnt that uncontrolled inputs managed by ref are much faster than controlled inputs because they don't trigger re-renders on every single keystroke.
- **Yup Schema Validation:** Wiring up Yup validation schemas to standard React Hook Form resolvers makes displaying custom validation errors incredibly simple.

## Questions & Struggles
- Getting Ant Design `<Select>` dropdowns to work with React Hook Form was a bit tricky. I had to wrap them inside a `<Controller>` component since they don't expose a standard HTML `<input>` ref.

## For Tomorrow's Standup
- When a user filters by "Late Close" working hours, does the backend use a hardcoded cutoff (e.g. closing after 21:00) or check store hours dynamically?
