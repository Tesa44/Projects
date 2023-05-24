import random
import math

def pierwsza(a):
    if a == 2:
        return True
    elif a < 2:
        return False
    elif a % 2 == 0:
        return False
    else:
        index = 1
        for i in range(3, int((a**0.5)) + 1):
            if a % i != 0:
                index = 1
            else:
                index = 0
                break
        if index == 1:
            return True
        else:
            return False

def liczby_pierwsze(p,k):
    pierwsze = []
    for liczba in range(p,k):
        if liczba == 2:
            pierwsze.append(liczba)
        index = 0
        for i in range(2, int((liczba**0.5)) + 1):
            if liczba % i != 0:
                index = 1
            else:
                index = 0
                break
        if index == 1:
            pierwsze.append(liczba)
    ind1 = random.randint(0,len(pierwsze))
    ind2 = random.randint(0,len(pierwsze))
    p = pierwsze[ind1]
    q = pierwsze[ind2]
    return p,q


def klucz_publiczny(phi):
    counter = True
    while counter:
        e = random.randint(3,phi)
        if math.gcd(phi,e) == 1:
            counter = False
            break
    return e


def rozszerzony_euklides(e, phi):
    x = 0
    v = 0
    u = 1
    y = 1
    a = e
    b = phi
    w = a
    z = b
    while w != 0:
        w = (a * u) + (b * v)
        z = (a * x) + (b * y)
        if w < z:
            x,u,v,y,w,z = u,x,y,v,z,w
        q = w // z
        roznica = w - (q * z)
        roznica = a  * (u - q * x) + b  * (v - q * y)

        u = u - q*x
        v = v - q*y
        w = w % z

    if math.gcd(a,b) == 1:
        if x < 0:
            return x+b
        else:
            return x

def deszyfrowanie(c,d,n):
    return (c**d) % n

def szyfrowanie_instrukcji(instrukcja,n):
    m = ""
    straznik = True
    for el in instrukcja:
        if ord(el) > 9 and ord(el) < 100:
            el = ord(el)
            m += str(el)
        else:
            straznik = False
            break
    if straznik and int(m) < n:
        m = int(m)
        return m


def deszyfrowanie_instrukcji(m):
    m = str(m)
    instrukcja = ""
    for i in range(0,len(m),2):
        ascii = int(m[i:i+2])
        instrukcja += chr(ascii)
    return instrukcja



def hakowanie_rsa(n):
    strażnik = False
    for p in range(2,n//2 +1):
        if pierwsza(p):
            if math.gcd(p,n) != 1:
                q = n//p
                if p*q == n:
                    strażnik = True
                    break
    if strażnik:
        return p,q
    else:
        return False

################
#SZYFRY_DO_WYBORU
################
#SZYFR_CEZARA
def szyfrowanie_cezar(tekst, k):
    tekst = tekst.upper()
    szyfrogram = ""
    for litera in tekst:
        if ord(litera) > 64 and ord(litera) < 91:
            # print(litera, ord(litera), end=" ")
            szyfr = (ord(litera) - 65 + k) % 26 + 65
            # print(chr(szyfr), szyfr)
            szyfrogram += chr(szyfr)
        else:
            szyfrogram += litera
    return szyfrogram

def odszyfrowanie_cezar(szyfrogram,k):
    szyfrogram = szyfrogram.upper()
    tekstjawny = ""
    for litera in szyfrogram:
        if ord(litera) > 64 and ord(litera) < 91:
            # print(litera, ord(litera), end=" ")
            szyfr = (ord(litera) - 65 - k) % 26 + 65
            # print(chr(szyfr), szyfr)
            tekstjawny += chr(szyfr)
        else:
            tekstjawny += litera
    return tekstjawny
#SZYFR_KOLUMNOWY
def szyfrowanie_kolumnowy(tekst,klucz):
    tekst = tekst.upper()
    if len(tekst) % klucz != 0:
        ile_dodac = len(tekst) % klucz
        tekst += "_"*(klucz - ile_dodac)
    szyfrogram = ""

    tab = []
    for i in range(0,len(tekst),klucz):
        tab.append(tekst[i:i+klucz])

    for j in range(0,klucz):
        for el in tab :
            szyfrogram += el[j]
    return szyfrogram

def deszyfrowanie_kolumnowy(tekst,klucz):
    tekst = tekst.upper()
    if len(tekst) % klucz != 0:
        ile_dodac = len(tekst) % klucz
        tekst += "_" * (klucz - ile_dodac)
    kolumny = len(tekst) // klucz
    wiersze = klucz
    szyfrogram = ""
    tab = []
    for i in range(0, len(tekst), kolumny):
        tab.append(tekst[i:i + kolumny])
        #TABLICA Z ELEMENTAMI PODZIELONYMY NA KOLUMNY
    for j in range(0,kolumny):
        for el in tab:
            szyfrogram += el[j]
    return szyfrogram
#SZYFR_PODSTAWIENIOWY
def szyfrowanie_podstawieniowy(tekst_jawny,klucz):
    while len(tekst_jawny) > len(klucz):
        klucz += klucz
    szyfrogram = ""
    polskie_duze_znaki = ["Ą","Ć","Ę","Ł","Ń","Ó","Ś","Ż","Ź"]
    polskie_male_znaki = ["ą","ć","ę","ł","ń","ó","ś","ż","ź"]
    i = 0
    for letter in tekst_jawny:
        if ord(letter) > 64 and ord(letter) < 91:
            przesun = ord(letter) - int(klucz[i])
            if przesun < 65:
                przesun += 26
            szyfrogram += chr(przesun)

        elif ord(letter) > 96 and ord(letter) < 123:
            przesun = ord(letter) - int(klucz[i])
            if przesun < 97:
                przesun += 26
            szyfrogram += chr(przesun)

        elif ord(letter) > 47 and ord(letter) < 58:
            przesun = ord(letter) - int(klucz[i])
            if przesun < 48:
                przesun += 10
            szyfrogram += chr(przesun)

        elif letter in polskie_duze_znaki:
            index = polskie_duze_znaki.index(letter)
            index -= int(klucz[i])
            szyfrogram += polskie_duze_znaki[index]

        elif letter in polskie_male_znaki:
            index = polskie_male_znaki.index(letter)
            index -= int(klucz[i])
            szyfrogram += polskie_male_znaki[index]

        else:
            szyfrogram += letter

        i += 1
    return szyfrogram
def deszyfrowanie_podstawieniowy(szyfr,klucz):
    while len(szyfr) > len(klucz):
        klucz += klucz
    polskie_duze_znaki = ["Ą", "Ć", "Ę", "Ł", "Ń", "Ó", "Ś", "Ż", "Ź"]
    polskie_male_znaki = ["ą", "ć", "ę", "ł", "ń", "ó", "ś", "ż", "ź"]
    jawny = ""
    i = 0
    for letter in szyfr:
        if ord(letter) > 64 and ord(letter) < 91:
            przesun = ord(letter) + int(klucz[i])
            if przesun > 90:
                przesun -= 26
            jawny += chr(przesun)

        elif ord(letter) > 96 and ord(letter) < 123:
            przesun = ord(letter) + int(klucz[i])
            if przesun > 122:
                przesun -= 26
            jawny += chr(przesun)

        elif ord(letter) > 47 and ord(letter) < 58:
            przesun = ord(letter) + int(klucz[i])
            if przesun > 57:
                przesun -= 10
            jawny += chr(przesun)

        elif letter in polskie_duze_znaki:
            index = polskie_duze_znaki.index(letter)
            index += int(klucz[i])
            if index > len(polskie_duze_znaki)-1:
                index = index % len(polskie_duze_znaki)
            jawny += polskie_duze_znaki[index]

        elif letter in polskie_male_znaki:
            index = polskie_male_znaki.index(letter)
            index += int(klucz[i])
            if index > len(polskie_male_znaki)-1:
                index = index % len(polskie_male_znaki)
            jawny += polskie_male_znaki[index]

        else:
            jawny += letter

        i += 1
    return jawny


# print(deszyfrowanie_instrukcji(945649))
# print(szyfrowanie_instrukcji("^81", 2513869))
# p = 242648958288128614541925147518101769011
# q = 299356840913214192252590475232148200447
print("#"*37)
print("Autor: Mateusz Tesarewicz")
print("Witam w moim programie do szyfrowania")
print("#"*37)
print("ETAP 1: Szyfrowanie")
while True:
    print("Wygeneruj liczby pierwsze: 0","|", "Wpisz liczby pierwsze ręcznie: 1")
    wybor1 = str(input())
    if wybor1 == "0":
        przedzial = str(input("Podaj początek i koniec przedziału oddzielony spacją (zalecane 1-1000): "))
        try:
            p,k = przedzial.split()
            p,k = int(p),int(k)
            if isinstance(p,int) and isinstance(k,int) and 0 < int(p) < int(k):
                p,q = liczby_pierwsze(int(p),int(k))
                print("Wybrano liczby: p = {} i q = {}".format(p,q))
                n = p * q
                phi = (p - 1) * (q - 1)
                break
            else:
                print("program idioto-odporny")
        except:
            print("program idioto-odporny")

    elif wybor1 == "1":
        while True:
            p = str(input("p = "))
            q = str(input("q = "))
            try:
                p = int(p)
                q = int(q)
                if pierwsza(p) and pierwsza(q) and p!=q:
                    n = p * q
                    phi = (p - 1) * (q - 1)
                    break
                    break
                else:
                    print("To nie są liczby pierwsze XD")
            except:
                print("program idioto-odporny")
        break
    else:
        print("program idioto-odporny")

while True:
    print("Wygeneruj liczbę e: 0", "|", "Wpisz liczbę e ręcznie: 1")
    wybor2 = str(input())
    if wybor2 == "0":
        e = klucz_publiczny(phi)
        d = rozszerzony_euklides(e,phi)
        print("Klucz publiczny to: e = {} n = {}".format(e, n))
        print("Klucz prywatny to: d = {}".format(d))
        break
    elif wybor2 == "1":
        while True:
            print("Liczba e musi być względnie pierwsza z φ(n) i 1 < e < φ(n)")
            e = str(input("Podaj liczbę e: "))
            try:
                e = int(e)
                if e > 1 and e < phi and rozszerzony_euklides(e,phi):
                    print("Klucz publiczny to: e = {} n = {}".format(e,n))
                    d = rozszerzony_euklides(e,phi)
                    print("Klucz prywatny to: d = {}".format(d))
                    break
                else:
                    print("Liczba e nie spełnia warunków XD")
            except:
                print("program idioto-odporny")
        break
    else:
        print("program idioto-odporny")
while True:
    print("Wpisz wiadomość w postaci liczby: 0 ", "|", "Zaszyfruj wiadomość do postaci liczby: 1")
    wybor3 = str(input())
    if wybor3 == "0":
        print("Wiadomość musi być mniejsza od {}".format(n))
        m = str(input("Podaj liczbę m: "))
        try:
            m = int(m)
            if m < n:
                c = (m**e) % n
                print("Wiadomość to: {}".format(m))
                print("Zaszyfrowana wiadomość to: {}".format(c))
                break
            else:
                print("Liczba nie jest mniejsza od {} XD".format(n))
        except:
            print("program idioto-odporny")
    elif wybor3 == "1":
        while True:
            print("Wiadomość jest szyfrowana za pomocą kodu ascii, każdy element wiadomości musi być z przedziału od 10 do 99 według tablicy ascii")
            print("Wiadomość musi być mniejsza od {}".format(n))
            instrukcja = str(input("Podaj wiadomość: "))
            if szyfrowanie_instrukcji(instrukcja,n):
                m = szyfrowanie_instrukcji(instrukcja,n)
                c = (m ** e) % n
                print("Wiadomość to: {}".format(m))
                print("Zaszyfrowana wiadomość to: {}".format(c))
                break
            else:
                print("Nieprawidłowy przedział elementów lub m > n XD")
    else:
        print("program idioto-odporny")


while True:
    print("Zaszyfruj tekst jawny: 0 ", "|", "Nie szyfruj i wyślij wiadomość m: 1")
    wybor4 = str(input())
    if wybor4 == "0":
        print("Podaj tekst jawny do zaszyfrowania:")
        tekst_jawny = str(input())
        while True:
            print("Wybierz metodę szyfrowania:")
            print("Szyfr Cezara: 0")
            print("Szyfr kolumnowy: 1")
            print("Szyfr podstawieniowy: 2")
            wybor5 = str(input())
            if wybor5 == "0" or wybor5 == "1" or wybor5 == "2":
                break
        while True:
            print("Zaszyfruj kluczem o wartości m: 0", "|", "Zaszyfruj według własnego klucza: 1")
            wybor6 = str(input())
            if wybor6 == "0" or wybor6 == "1":
                break
        if wybor5 == "0":
            if wybor6 == "0":
                klucz = int(m)
                szyfr = szyfrowanie_cezar(tekst_jawny,klucz)
            elif wybor6 == "1":
                while True:
                    klucz = str(input("Podaj klucz: "))
                    try:
                        klucz = int(klucz)
                        szyfr = szyfrowanie_cezar(tekst_jawny,klucz)
                        break
                    except:
                        print("Klucz musi być liczbą")
            print("Szyfrogram: {}".format(szyfr))
            print("Klucz {}".format(klucz))
            break

        elif wybor5 == "1":
            if wybor6 == "0":
                klucz = int(m)
                szyfr = szyfrowanie_kolumnowy(tekst_jawny,klucz)
            elif wybor6 == "1":
                while True:
                    klucz = str(input("Podaj klucz: "))
                    try:
                        klucz = int(klucz)
                        szyfr = szyfrowanie_kolumnowy(tekst_jawny, klucz)
                        break
                    except:
                        print("Klucz musi być liczbą")
            print("Szyfrogram: {}".format(szyfr))
            print("Klucz {}".format(klucz))
            break

        elif wybor5 == "2":
            if wybor6 == "0":
                klucz = str(m)
                szyfr = szyfrowanie_podstawieniowy(tekst_jawny,klucz)
            elif wybor6 == "1":
                while True:
                    klucz = str(input("Podaj klucz: "))
                    try:
                        klucz = int(klucz)
                        klucz = str(klucz)
                        szyfr = szyfrowanie_podstawieniowy(tekst_jawny, klucz)
                        break
                    except:
                        print("Klucz musi być liczbą")
            print("Szyfrogram: {}".format(szyfr))
            print("Klucz {}".format(klucz))
            break


    elif wybor4 == "1":
        print("Wiadomość została wysłana")
        break
    else:
        print("program idioto-odporny")
print()
print("#"*37)
print("ETAP 2: Deszyfrowanie")
print("Odebrano zaszyfrowaną wiadomość: {}".format(c))
print()
wybor1_1 = ""
while True:
    print("Podaj klucz publiczny oraz klucz prywatny do odszyfrowania wiadomości: 0 ", "|", "Zhakuj płytę główną jak Tiger Bonzo: 1")
    wybor1_1 = str(input())
    if wybor1_1 == "0" or wybor1_1 == "1":
        break
    else:
        print("program idioto-odporny")
if wybor1_1 == "0":
    while True:
        print("Klucz publiczny:")
        e1 = str(input("e: "))
        n1 = str(input("n: "))
        print("Klucz prywatny: ")
        d1 = str(input("d: "))
        try:
            e1,n1,d1 = int(e1),int(n1),int(d1)
            if e1 == e and n1 == n and d1 == d:
                print("Dane prawidłowe")
                break
            else:
                print("Dane nieprawidłowe XD")
        except:
            print("Dane nieprawidłowe XD")

elif wybor1_1 == "1":
    while True:
        print("Tiger Bonzo potrzbuje klucza publicznego")
        print("Klucz publiczny:")
        e1 = str(input("e: "))
        n1 = str(input("n: "))
        try:
            e1,n1 = int(e1),int(n1)
            if hakowanie_rsa(n1):
                p, q = hakowanie_rsa(n1)
                print("Szukanie liczb pierwszych...")
                if pierwsza(q):
                    print("Znaleziono liczby pierwsze es")
                    print("p = ", p)
                    print("q = ", q)
                    phi = (p - 1) * (q - 1)
                    d1 = rozszerzony_euklides(e, phi)
                    print("Znaleziono klucz prywatny: ", d1)
                    print("Sprawdzanie...")
                    if e1 == e and n1 == n and d1 == d:
                        print("Uzyskano dostęp es")
                        print("Dane prawidłowe")
                        break
                    else:
                        print("Błąd XD")
                else:
                    print("Błąd w kluczu")
            else:
                print("Błąd w kluczu")
        except:
            print("Błąd w kluczu")

while True:
    c1 = str(input("Podaj zaszyfrowaną wiadomość: "))
    print("Odszyfrowywanie...")
    try:
        c1 = int(c1)
        if c1 == c:
            m1 = deszyfrowanie(c1,d1,n1)
            print("Wiadomość to: {}".format(m1))
            break
        else:
            print("Błąd w zaszyfrowanej wiadomości XD")
    except:
        print("Błąd w zaszyfrowanej wiadomości XD")

wybor1_2 = ""
while True:
    print("Odszyfruj szyfrogram: 0 ", "|", "Zamień wiadomość na tekst i zakończ: 1", "Zakończ: 2")
    wybor1_2 = str(input())
    if wybor1_2 == "0" or wybor1_2 == "1" or wybor1_2 == "2":
        break
    else:
        print("program idioto-odporny")
if wybor1_2 == "0":
    print("Podaj szyfrogram: ")
    szyfrogram = str(input())
    while True:
        print("Wybierz metodę odszyfrowania:")
        print("Szyfr Cezara: 0")
        print("Szyfr kolumnowy: 1")
        print("Szyfr podstawieniowy: 2")
        wybor1_3 = str(input())
        if wybor1_3 == "0":
            print("Wiadomość to: {}    Wiadomość w postaci tekstu to: {}".format(m1,deszyfrowanie_instrukcji(m1)))
            klucz = str(input("Podaj klucz: "))
            try:
                klucz = int(klucz)
                jawny = odszyfrowanie_cezar(szyfrogram, klucz)
                print("Tekst jawny to: ")
                print(jawny)
                print()
                print("Zakończ: 0", "|", "Wybierz metodę ponownie: 1")
                wybor1_4 = str(input())
            except:
                print("Klucz musi być liczbą")
                print("Zakończ: 0", "|", "Wybierz metodę ponownie: 1")
                wybor1_4 = str(input())
            if wybor1_4 == "0":
                print("Jesteś koxem ")
                break
        elif wybor1_3 == "1":
            print("Wiadomość to: {}    Wiadomość w postaci tekstu to: {}".format(m1, deszyfrowanie_instrukcji(m1)))
            klucz = int(input("Podaj klucz: "))
            if isinstance(klucz,int):
                jawny = deszyfrowanie_kolumnowy(szyfrogram, klucz)
                print("Tekst jawny to: ")
                print(jawny)
                print()
                print("Zakończ: 0", "|", "Wybierz metodę ponownie: 1")
                wybor1_4 = str(input())
            else:
                print("Klucz musi być liczbą")
                print("Zakończ: 0", "|", "Wybierz metodę ponownie: 1")
                wybor1_4 = str(input())
            if wybor1_4 == "0":
                print("Jesteś koxem ")
                break
        elif wybor1_3 == "2":
            print("Wiadomość to: {}    Wiadomość w postaci tekstu to: {}".format(m1, deszyfrowanie_instrukcji(m1)))
            klucz = str(input("Podaj klucz: "))
            try:
                klucz = int(klucz)
                klucz = str(klucz)
                jawny = deszyfrowanie_podstawieniowy(szyfrogram, klucz)
                print("Tekst jawny to: ")
                print(jawny)
                print()
                print("Zakończ: 0", "|", "Wybierz metodę ponownie: 1")
                wybor1_4 = str(input())
            except:
                print("Klucz musi być liczbą")
                print("Zakończ: 0", "|", "Wybierz metodę ponownie: 1")
                wybor1_4 = str(input())
            if wybor1_4 == "0":
                print("Jesteś koxem ")
                break
        else:
            print("program idioto-odporny")

elif wybor1_2 == "1":
    print("Wiadomość to: {}    Wiadomość w postaci tekstu to: {}".format(m1, deszyfrowanie_instrukcji(m1)))
    print("Jesteś koxem ")
else:
    print("Jesteś koxem ")















# p = 401
# q = 6269
#
# n = p*q
#
# phi = (p-1) * (q-1)
#
# e = klucz_publiczny(phi)
# d = rozszerzony_euklides(e,phi)
#
# m = 945649
# c = (m**e) % n
# print("zaszyfrowana_instrukcja: ",c)
#
# print(deszyforwanie(c,d,n))
#
# klucz = m**79






