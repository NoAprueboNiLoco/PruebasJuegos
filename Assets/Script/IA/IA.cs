using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class IA : MonoBehaviour
{
    public int rutina;
    public float cronometro;
    public Animator myAnimator;
    public Quaternion angulo;
    public float grado;

    public GameObject target;




    void Start()
    {
        myAnimator = GetComponent<Animator>();
        target = GameObject.Find("Personaje");
    }

    // Update is called once per frame
    void Update()
    {
        comportamiento();
    }

    private void comportamiento()
    {


        if (Vector3.Distance(transform.position, target.transform.position) > 5)
        {
            myAnimator.SetBool("isChasing", false);
            cronometro += 1 * Time.deltaTime;

            if (cronometro >= 4)
            {
                rutina = Random.Range(0, 2);
                cronometro = 0;
            }
            switch (rutina)
            {
                case 0:
                    myAnimator.SetBool("isWalking", false);
                    break;
                case 1:
                    grado = Random.Range(0, 360);
                    angulo = Quaternion.Euler(0, grado, 0);
                    rutina++;
                    break;
                case 2:
                    transform.rotation = Quaternion.RotateTowards(transform.rotation, angulo, 0.5f);
                    transform.Translate(Vector3.forward * 1 * Time.deltaTime);
                    myAnimator.SetBool("isWalking", true);
                    break;
            }
        }
        else
        {
            var lookPos = target.transform.position - transform.position;
            lookPos.y = 0;
            var rotation = Quaternion.LookRotation(lookPos);
            transform.rotation = Quaternion.RotateTowards(transform.rotation, rotation, 3);
            myAnimator.SetBool("isWalking", false);
            myAnimator.SetBool("isChasing", true);
            transform.Translate(Vector3.forward * 3 * Time.deltaTime);
        }
    }
}
