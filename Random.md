## how to approach for a problem
- stay calm
- Don't directly answer 
    - clearify the question
        - ask what are the constraints
        - are there any duplicates, -ve numbers, etc
        - check edge cases
        - check if input is null or 0
        - provide/mention if any exceptions are necessary
        - watch out for overflow use value%10^7 if needed
        - tracking the state 
    - Check if we can change input 
        - if yes go forward
        - sometimes backend services or threads might be accessing the input
    - Use conditional Statement
    - what if the data is streams
    - how to handle with threads
    - how to write using Fn programming style

## words to use in interview
- Encounter 
    - Whenever I encounter the maximum value,
- reduces to 
    This reduces a nested loop checking all subarray combinations down to a single linear scan."
- Generate
    Generating actual substrings
- given
- where do i start
- How *relevant* is this to the problem



# Interview
 - give interview to the room mate
 - Have Flashcards to say one sentence or word answers ready at hand
 - Don't come off arrogant and unlikable 
 - Keep responses short and if need be expand on it
 - 



## AI Agents working
For engineers that are struggling to use (or see the value in) agent assisted coding, give this a try:

1. Pick a domain and language that you know really well. You should be confident that you could implement a good version of whatever you want to build, given enough time.

2. Write a design document (with the same care that you would for a team of humans). Include things like tech choices and invariants.

3. Ignore people talking about one-shot prompting, agent swarms, etc, and start by telling the agent to read your doc and confirm its understanding. 

4. Ask the agent to make an implementation plan, decompose the plan into work items and record them (I use a local issue tracker.. separate post)

5. Read every diff. Correct and critique the agent's work as if you were mentoring a junior developer.

For senior engineers, this isn't that much different than what you probably do anyway, except that the agent is always available, faster at typing, and happy to do painful refactors without complaint.