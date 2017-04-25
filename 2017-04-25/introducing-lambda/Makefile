JAVA_FILES=./se/juneday/MediaStore.java \
  ./se/juneday/TestFilter.java \
  ./se/juneday/Song.java \
  ./se/juneday/SongYearFilter.java \
  ./se/juneday/TestSong.java \
  ./se/juneday/Song70Filter.java \
  ./se/juneday/SongFilter.java \
  ./se/juneday/SongArtistComparator.java \
  ./se/juneday/Song709Filter.java \
  ./se/juneday/SongFilterer.java \
  ./se/juneday/TestSort.java 


CLASS_FILES=$(JAVA_FILES:%.java=%.class)

SORT_MAIN=se.juneday.TestSort
FILTER_MAIN=se.juneday.TestFilter

%.class:%.java
	javac $<

all: $(CLASS_FILES)

sort: $(CLASS_FILES)
	java $(SORT_MAIN)

filter: $(CLASS_FILES)
	java $(FILTER_MAIN)

edit:
	emacs -nw $(JAVA_FILES)

dist: $(JAVA_FILES)
	zip -r lambda-example.zip $(JAVA_FILES)

check:
	@echo "Java:  $(JAVA_FILES)"
	@echo 
	@echo "Class: $(CLASS_FILES)"

