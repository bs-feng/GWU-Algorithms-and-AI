from tkinter import *
import tkinter.messagebox

# functions


def print_result(result):
    tkinter.messagebox.showinfo("Win!", "{} is the winner!".format(result))


def game_winner():
    # eight situations that player win the game
    if(button1["text"] == button2["text"] == button3["text"] and button1["text"] != " "):
        print_result(button1["text"])
        return
    elif(button4["text"] == button5["text"] == button6["text"] and button4["text"] != " "):
        print_result(button4["text"])
        return
    elif(button7["text"] == button8["text"] == button9["text"] and button7["text"] != " "):
        print_result(button7["text"])
        return
    elif(button1["text"] == button4["text"] == button7["text"] and button1["text"] != " "):
        print_result(button1["text"])
        return
    elif(button2["text"] == button5["text"] == button8["text"] and button2["text"] != " "):
        print_result(button2["text"])
        return
    elif(button3["text"] == button6["text"] == button9["text"] and button3["text"] != " "):
        print_result(button3["text"])
        return
    elif(button1["text"] == button5["text"] == button9["text"] and button1["text"] != " "):
        print_result(button1["text"])
        return
    elif(button3["text"] == button5["text"] == button7["text"] and button3["text"] != " "):
        print_result(button3["text"])
        return
        # draw game
    global step
    if(step == 9):
        tkinter.messagebox.showinfo("DRAW", "The game is draw!")


def click(button):
    global current_player, step
    if button["text"] == " " and current_player == 1:
        button["text"] = "X"
        current_player = 2
        step += 1
    elif button["text"] == " " and current_player == 2:
        button["text"] = "O"
        current_player = 1
        step += 1
    game_winner()


def reset_game():
    global current_player, step
    current_player = 1
    step = 0
    button1["text"] = " "
    button2["text"] = " "
    button3["text"] = " "
    button4["text"] = " "
    button5["text"] = " "
    button6["text"] = " "
    button7["text"] = " "
    button8["text"] = " "
    button9["text"] = " "


def exit_game():
    window.destroy()
    exit()

# title of the game main window, the main
window = Tk()
window.title("Welcome to the Tic-Tac-Toe Game!")

# to track current player is X or O and the number of steps
current_player = 1
step = 0

# the grid of the game
button1 = Button(window, text=" ", font=("none 12 bold"),
                 width=8, command=lambda: click(button1))
button1.grid(row=0, column=0, sticky=W + S + N + E)
button2 = Button(window, text=" ", font=("none 12 bold"),
                 width=8, command=lambda: click(button2))
button2.grid(row=0, column=1, sticky=W + S + N + E)
button3 = Button(window, text=" ", font=("none 12 bold"),
                 width=8, command=lambda: click(button3))
button3.grid(row=0, column=2, sticky=W + S + N + E)
button4 = Button(window, text=" ", font=("none 12 bold"),
                 width=8, command=lambda: click(button4))
button4.grid(row=1, column=0, sticky=W + S + N + E)
button5 = Button(window, text=" ", font=("none 12 bold"),
                 width=8, command=lambda: click(button5))
button5.grid(row=1, column=1, sticky=W + S + N + E)
button6 = Button(window, text=" ", font=("none 12 bold"),
                 width=8, command=lambda: click(button6))
button6.grid(row=1, column=2, sticky=W + S + N + E)
button7 = Button(window, text=" ", font=("none 12 bold"),
                 width=8, command=lambda: click(button7))
button7.grid(row=2, column=0, sticky=W + S + N + E)
button8 = Button(window, text=" ", font=("none 12 bold"),
                 width=8, command=lambda: click(button8))
button8.grid(row=2, column=1, sticky=W + S + N + E)
button9 = Button(window, text=" ", font=("none 12 bold"),
                 width=8, command=lambda: click(button9))
button9.grid(row=2, column=2, sticky=W + S + N + E)


# reset and exit button for the game
Button(window, text="RESET", command=reset_game).grid(
    row=3, column=0, sticky=W)
Button(window, text="EXIT", command=exit_game).grid(row=3, column=1, sticky=W)

# run the main loop
window.mainloop()

###########
# References:
# https://www.youtube.com/watch?v=_lSNIrR1nZU
# https://docs.python.org/3/library/tkinter.html#tkinter-modules
# https://www.youtube.com/watch?v=RuYg_D_ppYk
###########
