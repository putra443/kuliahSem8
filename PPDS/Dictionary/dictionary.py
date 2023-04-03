def lyrics_to_frequencies(lyrics):
    myDict = {}
    for word in lyrics:
        if word in lyrics:
            myDict[word] +=1
        else:
            myDict[word] =1
    return myDict

def most_common_words(freqs):
    values = freqs.value()
    best = max(values)
    words= []
    for k in freqs:
        if freqs[k] == best:
            words.append(k)
    return (words, best)

def words_often(freqs, minTimes):
    result =[]
    done = False
    while not done:
        temp = most_common_words(freqs)
        if temp[1] >= minTimes:
            for w in temp[0]:
                del(freqs[w])
        else:
            done = True
    return result

# print(words_often("beatles", 5))