# Conflict Шийдвэрлэлт
## Conflict-ийн Дэлгэрэнгүй
`feature/add-multiply-validation`-ийг `develop` руу нэгтгэхэд
`src/main/java/labxx/sict/must/edu/mn/Multiplication.java` дээр merge conflict гарсан.
Conflict нь `multiply` функцын Javadoc коммент дээр байсан.
## Шийдвэрлэлтийн Алхмууд
1. Онцлогын салбарт `git merge develop` ажиллуулсан.
2. `Multiplication.java` дээрх conflict-ийг тодорхойлсон.
3. Файлыг засварлаж, хоёр салбарын Javadoc комментийг нэгтгэсэн.
4. `git add src/main/java/labxx/sict/must/edu/mn/Multiplication.java` ажиллуулсан.
5. `git commit` ажиллуулж merge-ийг дуусгасан.
6. Салбарыг push хийж, PR үүсгэсэн.
