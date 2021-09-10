from statistics import harmonic_mean


def calcular_media(nota_1, nota_2, nota_3, tipo_media):  # três valores numéricos e um carácter
    """
    Função que calcula uma média aritmética, ponderada ou harmônica.
    :param nota_1: Entrada com a primeira nota.
    :param nota_2: Entrada com a segunda nota.
    :param nota_3: Entrada com a terceira nota.
    :param tipo_media: Entrada com o tipo que será calculada a média.
    :return: Retorna a média.
    """
    if tipo_media == 'a':  # média aritmética.
        media_aritmetica = (nota_1 + nota_2 + nota_3) / 3
        print('Média aritmética: ', end='')
        return media_aritmetica

    elif tipo_media == 'p':  # média ponderada com pesos 5, 3 e 2.
        media_ponderada = (5 * nota_1 + 3 * nota_2 + 2 * nota_3) / 10
        print('Média ponderada: ', end='')
        return media_ponderada

    elif tipo_media == 'h':  # média harmônica.
        print('Média harmônica: ', end='')
        media_harmonica = harmonic_mean([nota_1, nota_2, nota_3])
        return media_harmonica


while True:  # Inicialização do laço infinito.
    print('---- Calculador De Média ----', end='\n\n')
    print("- TIPOS DE MÉDIAS -\n[A] - ARITMÉTICA \n[P] - PONDERADA \n[H] - HARMÔNICA")
    print('-' * 27)

    try:  # Faz uma tentativa de conversão das notas para float.
        # Escolher a média
        tipo = ' '
        while tipo not in 'aph':
            tipo = str(input('Sua escolha [A, P ou H]: ')).lower().strip()
        print('-' * 27)

        # Notas
        priNota = float(input('Informe a primeira nota: '))
        segNota = float(input('Informe a segunda nota: '))
        terNota = float(input('Informe a terceira nota: '))

        # verifica se as notas estão entre 0 e 10, caso não estejam, mostrará um erro.
        if (priNota < 0 or priNota > 10) or (segNota < 0 or segNota > 10) or (terNota < 0 or terNota > 10):
            print('-' * 27)
            print('\033[31mERRO: Informe valores entre 0 e 10!\033[m')
            continue

    except ValueError:  # Caso haja um erro na tentativa, mostrará um erro.
        print('-' * 27)
        print('\033[31mERRO: Informe um valor flutuante!\033[m')

    else:  # Caso a tentativa for realizada com sucesso.
        print('-' * 27)
        print(f'{calcular_media(priNota, segNota, terNota, tipo):.2f}')  # chamada da função
        print('-' * 27)

        parar = ' '
        while parar not in 'sn':
            parar = str(input('Deseja parar [s ou n]? ')).lower().strip()  # parar o programa
        if parar == 's':
            break

        print()
