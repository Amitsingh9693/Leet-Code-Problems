# Write your MySQL query statement below
select name as Customers from Customers as a left join Orders as b on a.id=b.customerId where customerId is null;