<h3>Problem Statement</h3>
<p>We need to determine whether a list of integers contains any duplicate values. In other words, if any number appears more than once in the list, the function should return <code>True</code>; otherwise, it should return <code>False</code>.</p>
<h3>Explanation of the Solution</h3>
<p>The provided function <code>contains_duplicate(numbers: list[int]) -&gt; bool</code> solves this problem efficiently using a <strong>set</strong> to keep track of the numbers that have already been seen while iterating through the list.</p>
<p>Here’s how it works step by step:</p>
<ol>
<li>
<p><strong>Initialize an empty set</strong> called <code>seen</code>.
   A set automatically prevents duplicate elements, making it ideal for this problem.</p>
</li>
<li>
<p><strong>Iterate through each number</strong> in the list <code>numbers</code>.
   For each number:</p>
</li>
<li>
<p>Check if it already exists in the <code>seen</code> set.</p>
<ul>
<li>If it does, that means we have found a duplicate, so the function immediately returns <code>True</code>.</li>
<li>If it doesn’t, add the number to the <code>seen</code> set and continue checking.</li>
</ul>
</li>
<li>
<p><strong>After the loop</strong>, if no duplicates were found, the function returns <code>False</code>.</p>
</li>
</ol>
<p>This approach ensures that each number is checked only once, giving it a <strong>time complexity of O(n)</strong> and a <strong>space complexity of O(n)</strong> (since, in the worst case, all numbers are unique and stored in the set).</p>
<h3>Example Runs</h3>
<ul>
<li><code>contains_duplicate([1, 2, 3, 1])</code> → returns <code>True</code> because <code>1</code> appears twice.</li>
<li><code>contains_duplicate([1, 2, 3, 4])</code> → returns <code>False</code> because all numbers are unique.</li>
</ul>