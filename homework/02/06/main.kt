import kotlin.random.Random
import java.awt.*

import java.awt.event.*

import javax.swing.*


class MyWindow(title:String) : JFrame(title)  {
	var changeTitle: JButton
	var animate: JButton

		init{
			animate = JButton("animate")
			changeTitle = JButton("change title")
			animate.addActionListener(object:ActionListener{
				var count: Int = 0

				override fun actionPerformed(e:ActionEvent){
					count++
					var s: Thread = Thread {
						while(true){
							Thread.sleep(4000)
							setLocation((1..500).random(), (1..500).random())
							if(count%2 == 0){
								setLocation(1,1)
							}
							}
					}
								s.start()

				}
			})
			changeTitle.addActionListener(object:ActionListener{
				override fun actionPerformed( e: ActionEvent ){
					var t: Thread = Thread {
						setLocation(200,200)
						setTitle("HELLO, WORLD")
					}
					t.start()
			}
			})

			setLayout(FlowLayout());
			add(changeTitle);
			add(animate);

		}
}


fun main(args : Array<String>) {
	var window = MyWindow("Kotlin is Fun!")
	window.pack()
	window.setVisible(true)
}


