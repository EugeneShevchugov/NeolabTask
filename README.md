В решении используется Обратная Польская Запись.
т.е. Выражение вида (*ТИП = ТРАВОЯДНОЕ, где *ТИП - Конкретный тип животного из файла) будет записано следующим образом ТИП * ТРАВОЯДНОЕ =

Несколько вариантов записей правил:

1.            Сколько животных – травоядных?

2.            Сколько животных – травоядных или плотоядных и они при этом маленькие?

3.            Сколько животных – всеядных, но не являются высокими?


1. В обычной записи - *ТИП = ТРАВОЯДНОЕ ; В ОПЗ - ТИП * ТРАВОЯДНОЕ =

2. В обычной записи - (*ТИП = ТРАВОЯДНОЕ | *ТИП = ПЛОТОЯДНОЕ) & РОСТ = МАЛЕНЬКОЕ ; В ОПЗ - ТИП * ТРАВОЯДНОЕ = ТИП * ПЛОТОЯДНОЕ = | РОСТ * МАЛЕНЬКОЕ = &

3. В обычной записи - *ТИП = ВСЕЯДНОЕ & РОСТ != ВЫСОКОЕ ; В ОПЗ - ТИП * ВСЕЯДНОЕ = РОСТ * ВЫСОКОЕ != &


ЗВЕЗДОЧКА Выступает как разыминователь записи. Условно: Имеется Животное с полем ТИП = ВСЕЯДНОЕ, Тогда запись под №1 будет выглядеть следующим образом: ВСЕЯДНОЕ = ТРАВОЯДНОЕ -> false -> output:0 -> Данное животное нам не подходит.
